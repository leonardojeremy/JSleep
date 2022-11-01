package LeonardoJeremyJSleepDN;

import java.util.regex.Pattern;

public class Renter extends Serializable
{
    public static final Pattern REGEX_PHONE = Pattern.compile("^[0-9]{9,12}$");
    public static final Pattern REGEX_NAME = Pattern.compile("^[A-Z][A-Za-z0-9_]{4,20}$");
    
    public Renter (String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate(){
        return (REGEX_PHONE.matcher(phoneNumber).matches()) && (REGEX_NAME.matcher(username).matches());
    }
    
    public String phoneNumber;
    public String address;
    public String username;
}
