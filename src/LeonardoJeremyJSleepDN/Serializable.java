package LeonardoJeremyJSleepDN;
import java.util.HashMap;
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter;
    public Serializable (int id){
        if (mapCounter.get(getClass()) != null){
            this.id = (mapCounter.get(getClass()) + 1);
        }
        else {
            this.id = 0;
        }
    }

    public Integer setClosingId(Class<?> key, int value){
        return mapCounter.put(key, value);
    }

    public Integer getClosingid(Class<?> key){
        return mapCounter.get(key);
    }

    public int compareTo(Serializable comp) {
        Integer newId = this.id;
        return newId.compareTo(comp.id);
    }

    public boolean equals(Object comp){
        if((((Serializable)comp).id == this.id) && (comp instanceof Serializable)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equals(Serializable comp) {
        if (this.id == comp.id){
            return true;
        }
        else {
            return false;
        }
    }
}