package com.LeonardoJeremyJSleepDN;

import com.LeonardoJeremyJSleepDN.dbjson.Serializable;

public class Account extends Serializable
{
    public double balance;
    public Renter renter;
    public String password;
    public String name;
    public static final String REGEX_EMAIL = "^[A-Za-z0-9_]{4,20}@[A-Za-z0-9_]{4,20}\\.[A-Za-z0-9_]{2,3}$";
    public String email;
    public static final String REGEX_PASSWORD = "^[A-Za-z0-9_]{4,20}$";



    public Account (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public boolean validate(){
        return (email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD));
    }
    public String toString(){
        return ("ID : " + id + "\nName : " + name + "\nEmail : " + email + "\nPassword : " + password);
    }
}
