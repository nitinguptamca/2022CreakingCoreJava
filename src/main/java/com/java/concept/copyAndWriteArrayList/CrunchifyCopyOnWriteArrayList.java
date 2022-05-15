package com.java.concept.copyAndWriteArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Crunchify.com
 * Its Iterator doesn’t supports remove() and throws UnsupportedOperationException for any attempt to do s
 * Has a fail-safe iterator as the iterator holds a cloned copy of the list
 * Is a thread-safe implementation and is present in the java.util.concurrent packages
 */

public class CrunchifyCopyOnWriteArrayList {

    /**
     * Removal And Iteration Over a CopyOnWriteArrayList:
     * The CopyOnWriteArrayList’s Iterator doesn’t support remove() operation.
     * Any attempt to do so will result in an UnsupportedOperationException:
     * @param args
     */
    /**
     * public class CopyOnWriteArrayList<E>
     * extends Object
     * implements List<E>, RandomAccess, Cloneable, Serializable
     * A thread-safe variant of ArrayList in which all mutative operations
     * (add, set, and so on) are implemented by making a fresh copy of the underlying array.
     * This is ordinarily too costly, but may be more efficient than alternatives when
     * traversal operations vastly outnumber mutations, and is useful when you cannot or don't
     * want to synchronize traversals, yet need to preclude interference among concurrent threads.
     */
    public static void main12(String[] args) {
        CopyOnWriteArrayList<String> list
                = new CopyOnWriteArrayList<>(new String[]{"A", "B"});

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            itr.remove();
        }
    }

    public static void main(String[] args) {

        // Disable this to avoid ConcurrentModificationException
        //List<String> companies = new ArrayList<>();

        // Enable this to avoid ConcurrentModificationException
        List<String> companies = new CopyOnWriteArrayList<>();

        companies.add("Google");
        companies.add("Yahoo");
        companies.add("Facebook");
        companies.add("eBay");
        companies.add("Microsoft");

        // Get an iterator over a collection. Iterator takes the place of
        // Enumeration in the Java Collections Framework.
        Iterator<String> crunchifyIterator = companies.iterator();

        // Make changes to companies List while performing hasNext()
        while (crunchifyIterator.hasNext()) {

            System.out.println("companies list: " + companies);

            String crunchifyString = crunchifyIterator.next();

            // Test1: Below statement causes ConcurrentModificationException
            System.out.println(crunchifyString);
            if (crunchifyString.equals("Yahoo"))
                // modCount = 6
                companies.remove("Microsoft");
            if (crunchifyString.equals("eBay"))
                companies.add("My Message Goes here... eBay present");

            // Test2: Below change wont throw ConcurrentModificationException
            // Reason: It doesn't change modCount variable of "companies"
            if (crunchifyString.equals("Google"))
                companies.set(2, "Google");

        }
    }
    /*
    private transient volatile Object[] array;
    *//** The lock protecting all mutators *//*
    final transient ReentrantLock lock = new ReentrantLock();
    public boolean add(E e) {
        *//** The array, accessed only via getArray/setArray. *//*

        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
*/
}
