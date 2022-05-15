package com.datastructure.cache.assignment1;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <li>
 *         I want to manage cache of all active users.<br>
 *         make user history if he is active last 10 minutes  and must be part of cache.<br>
 *         if user inactive more than 10 minutes then remove from cache.    <br>
 *         if user login more than 3 times with in 10 minutes then block user for certain period of time.
 * </li>
 */



public class CustomizeLRUCache <K extends Comparable<K>,V>{
    
    private static class Cache<K extends Comparable<K>,V>{
        K key;
        V value;
        LocalDateTime startTime;
        Cache<K ,V> next,prev;

        public Cache(K key, V value, LocalDateTime startTime) {
            this.key = key;
            this.value = value;
            this.startTime = startTime;
        }
    }

    int capacity;
    Map<K, Cache<K,V>> map = new HashMap<>();
    Cache head = null;
    Cache end = null;

    public CustomizeLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Cache<K ,V> n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return null;
    }
    /*This method will delete node*/
    public void delete(Cache<K,V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    /*This method will make passed node as head*/
    public void setHead(Cache<K,V> node) {
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        if (end == null)
            end = head;
    }

    public void set(K key, V value) {
        if (map.containsKey(key)) {
            // update the old value
            Cache<K,V> old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Cache<K,V> newCache = new Cache(key, value ,LocalDateTime.now());
            if (map.size() >= capacity) {
                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newCache);
            } else {
                setHead(newCache);
            }
            map.put(key, newCache);
        }
    }
}
