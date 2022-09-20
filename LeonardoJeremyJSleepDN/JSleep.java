package LeonardoJeremyJSleepDN;
/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    public static void main(String[] args){
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
    
    public static int getHotelID(){
        return 0;
    }
    
    public static String getHotelName(){
        return "hotel";
    }
    
    public static boolean isDiscount(){
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount < afterDiscount){
            return 0;
        }
        return (1 - afterDiscount / beforeDiscount) * 100;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        return price * (int)(1 - discountPercentage / 100);
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return discountedPrice / (int)(discountPercentage / 100);
        }
    
    public static float getAdminFeePercentage(){
        return (float)0.05;
    }
    
    public static int getAdminFee(int price){
        float percentage = getAdminFeePercentage();
        return price * (int)percentage;
    }
    
    public static int getTotalPrice(int price, int numberOfNight){
        price *= numberOfNight;
        float adminFee = getAdminFee(price);
        return (int)(price + adminFee);
    }
    
}
