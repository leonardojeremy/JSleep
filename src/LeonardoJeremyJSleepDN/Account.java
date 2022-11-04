package LeonardoJeremyJSleepDN;

public class Account extends Serializable
{
    public Account (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "^[A-Za-z0-9_]{4,20}@[A-Za-z0-9_]{4,20}\\.[A-Za-z0-9_]{2,3}$";
    public static final String REGEX_PASSWORD = "^[A-Za-z0-9_]{4,20}$";

    public boolean validate(){
        return (email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD));
    }
    public String toString(){
        return ("ID : " + id + "\nName : " + name + "\nEmail : " + email + "\nPassword : " + password);
    }
    
    public Object write(){
        return null;
    }
    
    public boolean read(String content){
        return false;
    }
}
