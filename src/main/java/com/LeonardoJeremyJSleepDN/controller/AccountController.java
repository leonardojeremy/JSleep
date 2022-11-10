package com.LeonardoJeremyJSleepDN.controller;

import com.LeonardoJeremyJSleepDN.Account;
import com.LeonardoJeremyJSleepDN.Algorithm;
import com.LeonardoJeremyJSleepDN.Predicate;
import com.LeonardoJeremyJSleepDN.Renter;
import com.LeonardoJeremyJSleepDN.dbjson.JsonAutowired;
import com.LeonardoJeremyJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.regex.Pattern;

import static org.apache.logging.log4j.util.Strings.isBlank;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_PASSWORD = "^[A-Za-z0-9_]{4,20}$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9_]{4,20}@[A-Za-z0-9_]{4,20}\\.[A-Za-z0-9_]{2,3}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    @JsonAutowired(value = JsonTable.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\account.json")
    public static JsonTable<Account> accountTable;

    @PostMapping("/{id}/topUp")
    public boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ){
        Account account = getById(id);
        if (account == null) return false;
        account.balance += balance;
        return true;
    }

    @PostMapping("/register")
    public Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        if(isBlank(name) && REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()){
            //Password Hashing
            String generatedPassword = null;
            try{
                //Message Digest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(password.getBytes());
                //get the hash's bytes
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //hashed password
                generatedPassword = sb.toString();
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            accountTable.add(new Account(name, email, generatedPassword));
            return new Account(name, email, password);
        }
        else return null;
    }

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @PostMapping("/login")
    public Account login(
            @RequestParam String email,
            @RequestParam String password
    )
    {
        //Password Hashing
        String generatedPassword = null;
        try{
            //Message Digest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //get the hash's bytes
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //hashed password
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return (Account) Algorithm.find((Iterable<Account>) accountTable, (Predicate<Account>) pred->pred.email.equals(email) && pred.password.equals(password));
    }

    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        if(isBlank(name) && REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()){
            return new Renter(name, email, password);
        }
        else return null;
    }
}
