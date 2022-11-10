package com.LeonardoJeremyJSleepDN;


public class Price
{
    public int price;
    public double discount;
    
    /*
    public double rebate;
    public double price;
    public int discount;
    */
   
    public Price(double price) {
        this.price = (int)price;
        this.discount = 0;
        //this.rebate = 0.0;
    }
    
    public Price(double price, double discount) {
        this.price = (int)price;
        this.discount = discount;
        //this.rebate = 0.0;
    }
    
    public String toString(){
        return ("Price : " + price + "\nDiscount : " + discount);
    }
    
    /*
    public Price(double price, double rebate) {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    
    private double getDiscountedPrice() {
        if (this.discount > 100) {
            return 100.0;
        }
        else if (this.discount == 0) {
            return 0.0;
        }
        else {
            return this.price - (double)this.discount;
        }
    }

    private double getRebatedPrice() {
        if (this.rebate > price) {
            return this.price;
        }
        else {
            return this.price - (double)this.rebate;
        }
    }
    */
    
    
}