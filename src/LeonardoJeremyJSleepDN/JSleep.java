package LeonardoJeremyJSleepDN;

import java.util.ArrayList;
import java.util.List;

public class JSleep
{


    public static void main(String[] args)
    {
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        /*
        try{
            String filepath = "json/randomRoomList.json";
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch(Throwable t){
            t.printStackTrace();
        }
        
         */

    }

    public static void createRoom(){
        Price testPrice = new Price(100000, 20000);
        Room room = new Room(100, "Leonardo", 10, testPrice, Facility.WiFi, City.DEPOK, "Jl Margonda Raya");
    }

    public static List<Room> filterByCity(List<Room> rooms, String city, int page, int pageSize){
        List<Room> filteredRooms = new ArrayList<>();
        int start = page * pageSize;
        int end = start + pageSize;
        for(int i = start; i < end; i++){
            Room room = rooms.get(i);
            if(room.city.name().toLowerCase().contains(city.toLowerCase())){
                filteredRooms.add(rooms.get(i));
            }
        }
        return filteredRooms;
    }

    public static List<Room> filterByPrice(List<Room> rooms, double minPrice, double maxPrice){
        List<Room> filteredRooms = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.price.price >= minPrice && room.price.price <= maxPrice){
                filteredRooms.add(rooms.get(i));
            }
        }
        return filteredRooms;
    }

    public static List<Room> filterByAccountId(List<Room> rooms, int accountId, int page, int pageSize){
        List<Room> filteredRooms = new ArrayList<>();
        int start = page * pageSize;
        int end = start + pageSize;
        for(int i = start; i < end; i++){
            Room room = rooms.get(i);
            if(room.accountId == accountId){
                filteredRooms.add(rooms.get(i));
            }
        }
        return filteredRooms;
    }

}

        /*
        // Read the file
        String filepath = "C:\\_UNI\\OOP\\_Praktikum OOP\\UNTUK PRAKTIKUM OOP\\JSleep\\src\\city.json";
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state->System.out.println(state));
        }
        catch(IOException e){
            e.printStackTrace();
        }
         */
        /*
        public static void main(String[] args){
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        }

        public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room kamar1 = new Room(14,"Restaurant",13,price,Facility.AC,City.JAKARTA,"Jl.Tebet");
        return kamar1;
        */

        /*
        Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }
        
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));
        */
       
        /*
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
        */
        
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

