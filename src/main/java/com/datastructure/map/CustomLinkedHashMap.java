package com.datastructure.map;

import java.util.LinkedHashMap;

/**
 * public class LinkedHashMap<K,V>
 *     extends HashMap<K,V>
 *     implements Map<K,V>
 * @param <K>
 * @param <V>
 *         static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *     Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
 *         LinkedHashMap.Entry<K,V> p =
 *             new LinkedHashMap.Entry<>(hash, key, value, e);
 *         linkNodeLast(p);
 *         return p;
 *     }
 *
 */

public class CustomLinkedHashMap<K,V> {

    transient Entry<K,V> head;
    /**
     * The tail (youngest) of the doubly linked list.
     */
    transient Entry<K,V> tail;

    static class Entry<K,V> {
        Entry<K,V> before, after;
        K key;
        V value;
    }

    // link at the end of list
    private void linkNodeLast(Entry<K,V> p) {
        Entry<K,V> last = tail;
        tail = p;
        if (last == null)
            head = p;
        else {
            p.before = last;
            last.after = p;
        }
    }
}
