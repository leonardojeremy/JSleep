package LeonardoJeremyJSleepDN;


/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class JSleep
     */

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void main(String[] args){

        System.out.println("Hotel ID   : " + getHotelID());
        System.out.println("Hotel Name : " + getHotelName());
        System.out.println("Discount   : " + isDiscount());
        float discountPercentage = getDiscountPercentage(1000, 800);
        System.out.println("Discount Percenteage : " + discountPercentage);
        
        int price = 1500;
        int discountedPrice = getDiscountedPrice(price, discountPercentage);
        
        System.out.println("Original Price : " + getOriginalPrice(price, discountPercentage));
        
        int adminFee = getAdminFee(price);
        
        int totalPrice = getTotalPrice(price, 5);
        
        System.out.println("Total Price : " + totalPrice);
    }
    
    public int getHotelID(){
        return 0;
    }
    
    public String getHotelName(){
        return "hotel";
    }
    
    public boolean isDiscount(){
        return true;
    }
    
    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount < afterDiscount){
            return 0;
        }
        return (1 - afterDiscount / beforeDiscount) * 100;
    }
    
    public int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        return price * (1 - discountPercentage / 100);
    }
    
    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        return discountedPrice / (discountPercentage / 100)
        }
    
    public float getAdminFeePercentage(){
        return 0.05;
    }
    
    public int getAdminFee(int price){
        float percentage = getAdminFeePercentage();
        return price * percentage;
    }
    
    public int getTotalPrice(int price, int numberOfNight){
        price *= numberOfNight;
        float adminFee = getAdminFee(price);
        return price + adminFee;
    }
    
}
