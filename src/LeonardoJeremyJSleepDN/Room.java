package LeonardoJeremyJSleepDN;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;
    public int accountId;

    
    
    public Room (int accountId, String name, int size, Price price, Facility facility, City city, String address) {
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.bedType = BedType.QUEEN;
        this.booked = new ArrayList<Date>();
        this.accountId = accountId;
    }
    
    public String toString (){
        return ("Size : "+ size + "\nName : " + name + "\nFacility : " + facility + "\nPrice : " + price + "\nCity : " + city + "\nBed Type : " + bedType + "\nAddress : " + address + "\nBooked : " + booked + "\nAccount ID : " + accountId);
    }
    
    public Object write(){
        return null;
    }
    
    public boolean read(String content){
        return false;
    }
}
