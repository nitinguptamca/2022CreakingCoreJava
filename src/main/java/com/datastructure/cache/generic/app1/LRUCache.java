package com.datastructure.cache.generic.app1;

import java.util.HashMap;
import java.util.Map;

class Cache<K ,V> {
    K key;
    V value;
    Cache prev;
    Cache next;
    public Cache(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<K ,V> {

    int capacity;
    Map<K, Cache<K,V>> map = new HashMap<>();
    Cache head = null;
    Cache end = null;

    public LRUCache(int capacity) {
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
            Cache<K,V> newNode = new Cache(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }
}
