package com.datastructure.cache.generic.app1;

import java.util.HashMap;
import java.util.Map;

class Node<K ,V> {
    K key;
    V value;
    Node prev;
    Node next;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<K ,V> {

    int capacity;
    Map<K, Node<K,V>> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K ,V> n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return null;
    }
    /*This method will delete node*/
    public void delete(Node<K,V> node) {
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
    public void setHead(Node<K,V> node) {
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
            Node<K,V> old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Node<K,V> newNode = new Node(key, value);
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
