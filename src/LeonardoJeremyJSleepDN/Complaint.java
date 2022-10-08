package LeonardoJeremyJSleepDN;

public class Complaint extends Serializable
{
    public Complaint(int id, String date, String desc){
        super(id);
        this.desc = desc;
        this.date = date;
    }
    public String desc;
    public String date;
    
    public String toString(){
        return ("id : " + id + "\ndate : " + date + "\ndesc : " + desc);
    }
}
