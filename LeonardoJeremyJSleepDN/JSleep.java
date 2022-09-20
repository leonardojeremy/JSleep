package LeonardoJeremyJSleepDN;


public class JSleep
{
    public static void main(String[] args){
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
        /*
        System.out.println("Hotel ID   : " + getHotelID());
        System.out.println("Hotel Name : " + getHotelName());
        System.out.println("Discount   : " + isDiscount());
        float discountPercentage = getDiscountPercentage(2000, 1000);
        System.out.println("Discount Percenteage : " + discountPercentage);
        
        int price = 2000;
        price = getDiscountedPrice(price, discountPercentage);
        
        System.out.println("Original Price : " + getOriginalPrice(price, discountPercentage));
        System.out.println("Disc Price : " + price);
        int adminFee = getAdminFee(price);
        
        int totalPrice = getTotalPrice(price, 5);
        System.out.println("Admin Fee : " + adminFee);
        System.out.println("Total Price : " + totalPrice);
        */
    }
    
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room kamar1 = new Room("Hotel 1", 30, price, Facility.AC);
        return kamar1;
    }
    
    /*
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
        else{
            return (1-((float)afterDiscount / (float)beforeDiscount)) * 100;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        else{
            return (int)(price * (1.0 - (discountPercentage / 100)));
        }
        
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (int)((float)discountedPrice / (discountPercentage / 100));
        }
    
    public static float getAdminFeePercentage(){
        return (float)0.05;
    }
    
    public static int getAdminFee(int price){
        float percentage = getAdminFeePercentage();
        return (int)((float)price * percentage);
    }
    
    public static int getTotalPrice(int price, int numberOfNight){
        price *= numberOfNight;
        float adminFee = (float)(getAdminFee(price));
        return price + (int)adminFee;
    }
    */
    
}
