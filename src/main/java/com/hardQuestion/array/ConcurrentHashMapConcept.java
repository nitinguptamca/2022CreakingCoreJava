package com.hardQuestion.array;

/**
 * The table inside ConcurrentHashMap is divided among Segments (which extends Reentrant Lock), each
 * of which itself is a concurrently readable hash table. Each segment requires uses single lock to consistently
 * update its elements flushing all the changes to main memory
 *
 * Iterator returned by the ConcurrentHashMap is fail-safe but weakly consistent. keySet().iterator() returns
 * the iterator for the set of hash keys backed by the original map. The iterator is a "weakly consistent" iterator
 * that will never throw ConcurrentModificationException, and guarantees to traverse elements as they existed
 * upon construction of the iterator, and may (but is not guaranteed to) reflect any modifications subsequent to
 * construction. Because its working on clone copy.
 *
 *
 * @param <K>
 * @param <V>
 */

/////https://medium.com/art-of-coding/hash-table-vs-concurrent-hashmap-and-its-internal-working-b28fc2725bdb
public class ConcurrentHashMapConcept<K,V> {
   // private transient Node<K,V>[] table;
   // private transient volatile Node<K,V>[] table;


///The segment in CHM is nothing but “a specialized hash table”.The default size is 16, meaning
// max 16 threads can work at a time.
//Each thread can work on each segment during high concurrency and at most 16 threads can
// operate at max which simply maintains 16locks to guard each bucket of the ConcurrentHashMap.
/*
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        // Implementations of methods like replace,clear,put etc.
        // Each such operation is handled by the particular Segment.
    }
    public V put(K key, V value) {
        Segment<K,V> s;
        // get the segment
      //  return s.put(key, hash, value, false); // calls the put method implemented in Segment (inner)class.
    }*/
    ///-------------------------------------
/*
    public V get(Object key) {
        Segment<K,V> s; // manually integrate access methods to reduce overhead
        HashEntry<K,V>[] tab;
        int h = hash(key.hashCode());
        long u = (((h >>> segmentShift) & segmentMask) << SSHIFT) + SBASE;
        if ((s = (Segment<K,V>)UNSAFE.getObjectVolatile(segments, u)) != null &&
                (tab = s.table) != null) {
            for (HashEntry<K,V> e = (HashEntry<K,V>) UNSAFE.getObjectVolatile
                    (tab, ((long)(((tab.length - 1) & h)) << TSHIFT) + TBASE);
                 e != null; e = e.next) {
                K k;
                if ((k = e.key) == key || (e.hash == h && key.equals(k)))
                    return e.value;
            }
        }
        return null;
    }

*/
/*
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K, V> next;
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {            return null;        }
        @Override
        public V getValue() {            return null;        }
        @Override
        public V setValue(V value) {            return null;        }
    }
    */


}
