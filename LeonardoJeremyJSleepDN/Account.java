package LeonardoJeremyJSleepDN;

public class Account extends Serializable
{
    public Account (int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String name;
    public String email;
    public String password;
    
    public String toString(){
        return ("ID : " + id + "\nName : " + name + "\nEmail : " + email + "\nPassword : " + password);
    }
}