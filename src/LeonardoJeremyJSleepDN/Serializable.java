package LeonardoJeremyJSleepDN;
import java.util.HashMap;
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter;
    protected Serializable() {
        if (mapCounter == null) {
            mapCounter = new HashMap<Class<?>, Integer>();
        }
        Class<?> cls = this.getClass();
        if (mapCounter.containsKey(cls)) {
            int count = mapCounter.get(cls);
            mapCounter.put(cls, count + 1);
        }
        else {
            mapCounter.put(cls, 1);
        }
        this.id = mapCounter.get(cls);
    }

    public Integer setClosingId(Class<?> key, int value){
        return mapCounter.put(key, value);
    }

    public Integer getClosingId(Class<?> key){
        return mapCounter.get(key);
    }

    public int compareTo(Serializable comp) {
        Integer newId = this.id;
        return newId.compareTo(comp.id);
    }

    public boolean equals(Object comp){
        return ((Serializable) comp).id == this.id;
    }

    public boolean equals(Serializable comp) {
        return this.id == comp.id;
    }
}