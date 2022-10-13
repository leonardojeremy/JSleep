package LeonardoJeremyJSleepDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {

    public static <T> List<T> collect(Iterable<T> iterable, T value){
        List<T> list = new ArrayList<>();
        for (T next : iterable) {
            if (next.equals(value)) {
                list.add(next);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for (T next : iterable) {
            if (predicate.predicate(next)) {
                list.add(next);
            }
        }
        return list;
    }

    public static <T> List<T> collect(T[] array, T value){
        List<T> list = new ArrayList<>();
        for (T t : array){
            if (t.equals(value)){
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value){
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (next.equals(value)){
                list.add(next);
            }
        }
        return list;
    }

    public static <T> List<T> collect(T[] array, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for (T t : array){
            if (predicate.predicate(t)){
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (predicate.predicate(next)){
                list.add(next);
            }
        }
        return list;
    }

    public static <T> int count(Iterator<T> iterator, T value){
        int count = 0;
        while(iterator.hasNext() == true){
            if(iterator.next().equals(value) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(T[] array, T value){
        int count = 0;
        for(T item : array){
            if(item.equals(value) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable , Predicate<T> predicate) {
        int count = 0;
        for(T item : iterable){
            if(predicate.predicate(item) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(T[] array, Predicate<T> predicate){
        int count = 0;
        for(T item : array){
            if(predicate.predicate(item) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate){
        int count = 0;
        while(iterator.hasNext()){
            if(predicate.predicate(iterator.next()) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        int count = 0;
        for(T item : iterable){
            if(item.equals(value) == true){
                count++;
            }
        }
        return count;
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value :: equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find (T[] array, Predicate<T> predicate){
        for(T item : array){
            if(predicate.predicate(item) == true){
                return item;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> predicate){
        for(T item : iterable){
            if(predicate.predicate(item) == true){
                return item;
            }
        }
        return null;
    }

    public static <T> T find (T[] array, T value){
        for(T item : array){
            if(item.equals(value) == true){
                return item;
            }
        }
        return null;
    }

    public static <T> T find (Iterable<T> iterable, T value){
        for(T item : iterable){
            if(item.equals(value) == true){
                return item;
            }
        }
        return null;
    }

    public static <T> T find (Iterator<T> iterator, T value){
        while(iterator.hasNext()){
            if(iterator.next().equals(value) == true){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> T find (Iterator<T> iterator, Predicate<T> predicate){
        while(iterator.hasNext()){
            if(predicate.predicate(iterator.next()) == true){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> List<T> paginate (T[] array, int start, int end, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(predicate.predicate(array[i])){
                list.add(array[i]);
            }
        }
        return list;
    }

    public static <T> List<T> paginate (Iterator<T> iterator, int start, int end, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for(int i = start; i < end; i++){
            if(predicate.predicate(iterator.next())){
                list.add(iterator.next());
            }
        }
        return list;
    }

    public static <T> List<T> paginate (Iterable<T> iterable, int start, int end, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for(int i = start; i < end; i++){
            if(predicate.predicate(iterable.iterator().next())){
                list.add(iterable.iterator().next());
            }
        }
        return list;
    }

}
