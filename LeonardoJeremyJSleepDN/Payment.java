package LeonardoJeremyJSleepDN;

public class Payment extends Invoice
{
    public Payment (int id, Account buyer, Renter renter, String time, int roomId, String from, String to) {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment (int id, int buyerId, int renterId, String time, int roomId, String from, String to) {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public String to;
    public String from;
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
    
}
