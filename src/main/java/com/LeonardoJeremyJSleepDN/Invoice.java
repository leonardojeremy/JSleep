package com.LeonardoJeremyJSleepDN;

import com.LeonardoJeremyJSleepDN.dbjson.Serializable;

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

    public PaymentStatus status;
    public RoomRating rating;
    public int buyerId;
    public int renterId;
    
    protected Invoice (int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice (Account buyer, Renter renter) {
        this.buyerId = buyer.id; 
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    } 
    
    public String print(){
        return ("ID : " + id + "\n" + "Buyer ID : " + buyerId + "\n" + "Renter ID : " + renterId);

    }
    
}
