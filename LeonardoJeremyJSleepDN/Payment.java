package LeonardoJeremyJSleepDN;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Payment extends Invoice
{
    public Payment (int id, Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment (int id, int buyerId, int renterId, int roomId, Date from, Date to) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Date to;
    public Date from;
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
    
    public static boolean makeBooking(Date from, Date to, Room room){
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String formatForm = format.format(from.getTime());
        String formatTo = format.format(to.getTime());
        
        Calendar cal = Calendar.getInstance();
        
        if(availability(from, to, room) == true){
            while (from.before(to)){
                room.booked.add(from);
                cal.setTime(from);
                cal.add(Calendar.DATE, 1);
                from = cal.getTime();
            }
            return true;
        }
        else{
             return false;   
        }
        
    }
    
    public static boolean availability(Date from, Date to, Room room){
        if (room.booked.isEmpty() == true){
            return true;
        }
        else if (to.before(from) == true){
            return false;
        }
        else {
            for (Date iterator : room.booked){
                if (iterator.after(from) && iterator.before(to)){
                    return false;
                }
            }
            return true;
        }
    }
    
}
