package LeonardoJeremyJSleepDN;
import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {
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

}
