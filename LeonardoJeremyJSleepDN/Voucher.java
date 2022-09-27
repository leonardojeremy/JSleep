package LeonardoJeremyJSleepDN;

public class Voucher extends Serializable
{
    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }
        
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public boolean canApply(Price price){
        if (price.price > this.minimum && this.used == false){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply(Price price){
        this.used = true;
        if (this.type == type.DISCOUNT){
            return price.price - (price.price*(this.cut/100));
        }
        else if (this.type == type.REBATE){
            return price.price - this.cut;
        }
        else{
            return 0;
        }
    }
    
    public boolean isUsed(){
        return this.used;
    }
}
