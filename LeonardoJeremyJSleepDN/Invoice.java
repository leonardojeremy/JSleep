package LeonardoJeremyJSleepDN;
import java.util.Calendar;

public class Invoice extends Serializable
{
    public enum RoomRating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum PaymentStatus
    {   
        FAILED, WAITING, SUCCESS
    }

    protected Invoice (int id, int buyerId, int renterId){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice (int id, Account buyer, Renter renter) {
        super(id);
        this.buyerId = buyer.id; 
        this.renterId = renter.id;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public PaymentStatus status;
    public RoomRating rating;
    public int buyerId;
    public int renterId;
    public Calendar time;
    
    public String print(){
        return ("ID : " + id + "\n" + "Buyer ID : " + buyerId + "\n" + "Renter ID : " + renterId + "\n" + "Time : " + time + "\n");
                
    }
    
}
