package interview.assignment;

public class CustomMap<K extends Comparable<K>,V> {

    Entry<K,V> table[];
    int capacity;

    public CustomMap( int capacity ){
        table = new Entry[capacity];
    }

    private class Entry<K extends Comparable<K>,V>{
        K key;
        V value;
        Entry<K,V>  next;
        Entry(K key ,V value){
            this.key=key;
            this.value=value;
        }
    }

    public void put(K key ,V value){
        int hashcodeV= getHashcode(key);
        if(table[hashcodeV]==null){
            table[hashcodeV]= new Entry<>(key, value);
        }else{



        }
    }

    private int getHashcode(K key) {
       return 0;
    }

}
