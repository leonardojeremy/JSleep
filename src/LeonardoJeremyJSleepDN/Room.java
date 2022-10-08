package LeonardoJeremyJSleepDN;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;
    
    
    public Room (int id, String name, int size, Price price, Facility facility, City city, String address) {
        super(id);
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
    }
    
    public String toString (){
        return ("ID : " + id + "\nSize : "+ size + "\nName : " + name + "\nFacility : " + facility + "\nPrice : " + price + "\nCity : " + city + "\nBed Type : " + bedType + "\nAddress : " + address);
    }
    
    public Object write(){
        return null;
    }
    
    public boolean read(String content){
        return false;
    }
}
