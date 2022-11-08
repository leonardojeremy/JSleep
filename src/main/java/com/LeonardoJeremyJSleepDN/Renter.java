package com.LeonardoJeremyJSleepDN;

import com.LeonardoJeremyJSleepDN.dbjson.Serializable;

public class Renter extends Serializable
{
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    public static final String REGEX_NAME = "^[A-Z][A-Za-z0-9_]{4,20}$";
    
    public Renter (String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate(){
        return (phoneNumber.matches(REGEX_PHONE) && username.matches(REGEX_NAME));
    }
    
    public String phoneNumber;
    public String address;
    public String username;
}
