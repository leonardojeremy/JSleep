package LeonardoJeremyJSleepDN;


public class JSleep
{
    public static void main(String[] args){
        
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
        
        /*
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());
        */
       
        /*
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
        */
       
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
    
    /*
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room kamar1 = new Room("Hotel 1", 30, price, Facility.AC);
        return kamar1;
    }
    */
    
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
