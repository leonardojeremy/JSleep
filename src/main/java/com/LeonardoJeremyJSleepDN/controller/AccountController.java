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

import static com.LeonardoJeremyJSleepDN.Algorithm.find;
import static org.apache.logging.log4j.util.Strings.isBlank;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    @JsonAutowired(value = JsonTable.class, filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\json\\account.json")
    public static JsonTable<Account> accountTable;

    @PostMapping("/{id}/topUp")
    public boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/register")
    public Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        if(!isBlank(name) && REGEX_PATTERN_EMAIL.matcher(email).find() && REGEX_PATTERN_PASSWORD.matcher(password).find()){
            //Password Hashing
            String generatedPassword = null;
            boolean emailstatus = REGEX_PATTERN_EMAIL.matcher(email).find();
            boolean passwordstatus = REGEX_PATTERN_PASSWORD.matcher(password).find();

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
            return new Account(name, email, generatedPassword);
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

        String finalGeneratedPassword = generatedPassword;
        return Algorithm.<Account>find(accountTable, pred -> email.equals(pred.email) && finalGeneratedPassword.equals(pred.password));
    }

    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @GetMapping
    String index(){
        return "Hello World";
    }

}
