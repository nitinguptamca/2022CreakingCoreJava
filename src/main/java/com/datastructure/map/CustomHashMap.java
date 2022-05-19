package com.datastructure.map;

import  java.util.LinkedHashMap;

public class CustomHashMap<K extends Comparable<K>, V> {
    private Entry<K, V>[] table = null;

    public Entry<K, V>[] getTable() {
        return table;
    }

    public void putAll(HashMap<? extends K, ? extends V> m) {
        Entry<K, V>[] table = getTable();
        for (Entry<K, V> entry : table) {
            put(entry.key, entry.value);
        }
    }

    int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    static class Entry<K extends Comparable<K>, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public void remove(K removeKey) {
        int h = getHashCode(removeKey);
        Entry<K, V> prev = table[h];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.key.compareTo(removeKey)==0) {
                if (prev == e) {
                    table[h] = next;
                } else {
                    prev.next = next;
                }
            }
            prev = e;
            e = next;
        }
    }


    public Entry<K, V> get(K searchKey) {
        final int hashCode = getHashCode(searchKey);
        if (table[hashCode] != null) {
            Entry<K, V> current = table[hashCode];
            while (current != null) {
                if (current.key.compareTo(searchKey) == 0) {
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

    public void put(K newKey, V value) {
        int hashCode = getHashCode(newKey);
        Entry<K, V> newEntry = new Entry<>(newKey, value, null);
        if (table[hashCode] == null) {
            table[hashCode] = newEntry;
        } else {
            Entry<K, V> current = table[hashCode];
            Entry<K, V> previous = null;
            while (current != null) {
                if (current.key.compareTo(newKey) == 0) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hashCode] = newEntry;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    private int getHashCode(K key) {
        return key.hashCode() % capacity;
    }

    public void printAll() {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                System.out.println(entry);
                entry = entry.next;
            }
        }
    }

}
