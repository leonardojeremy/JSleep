package LeonardoJeremyJSleepDN;

public class Room
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    
    public Room (String name, int size, Price price, Facility facility) {
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
    }
}