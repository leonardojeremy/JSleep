package LeonardoJeremyJSleepDN;
import java.util.*;

public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Double> result = new ArrayList<Double>();
        for (Price price : list){
            if(less == true) {
                if (price.price <= value){
                    result.add(price.price);
                }
            }
            else{
                if(price.price > value){
                    result.add(price.price);
                }
            }
        }
        return result;
    }
}