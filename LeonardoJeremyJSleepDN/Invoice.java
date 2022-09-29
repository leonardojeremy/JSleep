package LeonardoJeremyJSleepDN;


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

    protected Invoice (int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice (int id, Account buyer, Renter renter, String time) {
        super(id);
        this.buyerId = buyer.id; 
        this.renterId = renter.id;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public PaymentStatus status;
    public RoomRating rating;
    public int buyerId;
    public int renterId;
    public String time;
    
    public String print(){
        return ("ID : " + id + "\n" + "Buyer ID : " + buyerId + "\n" + "Renter ID : " + renterId + "\n" + "Time : " + time + "\n");
                
    }
    
}
