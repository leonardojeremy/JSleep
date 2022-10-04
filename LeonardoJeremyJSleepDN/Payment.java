package LeonardoJeremyJSleepDN;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Payment extends Invoice
{
    public Payment (int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public Payment (int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    public String print(){
        return ("ID : " + id + "\n" +
                "Buyer ID : " + buyerId + "\n" +
                "Renter ID : " + renterId + "\n" +
                "Time : " + time + "\n" +
                "Room ID : " + roomId + "\n" +
                "From : " + from + "\n" +
                "To : " + to + "\n");
    }
    
    public int getRoomId(){
        return this.roomId;
    }
    
    public String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        return format.format(super.time.getTime());
    }
    
    public String getDuration(){
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        return (format.format(from.getTime()) + " - " + format.format(to.getTime()));
    }
    
}
