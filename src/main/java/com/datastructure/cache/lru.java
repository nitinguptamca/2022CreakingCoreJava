package com.datastructure.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Cache1 {
    int key;
    String value;

    Cache1(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class lru {
    static Deque<Integer> q = new LinkedList<>();
    static Map<Integer, Cache1> map = new HashMap<>();
    int CACHE_CAPACITY = 4;

    public static void main(String[] args) {
        lru cache = new lru();
        cache.putElementInCache(1, "Value_1");
        cache.putElementInCache(2, "Value_2");
        cache.putElementInCache(3, "Value_3");
        cache.putElementInCache(4, "Value_4");
        cache.putElementInCache(5, "Value_1");
        cache.putElementInCache(6, "Value_2");
        cache.putElementInCache(7, "Value_3");
        cache.putElementInCache(8, "Value_4");
        System.out.println(cache.getElementFromCache(2));
        System.out.println();
        System.out.println(q);
        System.out.println();
        System.out.println(cache.getElementFromCache(5));
        cache.putElementInCache(5, "Value_5");
        System.out.println();
        System.out.println(q);
        System.out.println();
    }

    public String getElementFromCache(int key) {
        if (map.containsKey(key)) {
            Cache1 current = map.get(key);
            q.remove(current.key);
            q.addFirst(current.key);
            return current.value;
        }
        return "Not exist";
    }

    public void putElementInCache(int key, String value) {
        if (map.containsKey(key)) {
            Cache1 curr = map.get(key);
            q.remove(curr.key);
        } else {
            if (q.size() == CACHE_CAPACITY) {
                int temp = q.removeLast();
                map.remove(temp);
            }
        }
        Cache1 newItem = new Cache1(key, value);
        q.addFirst(newItem.key);
        map.put(key, newItem);
    }
}