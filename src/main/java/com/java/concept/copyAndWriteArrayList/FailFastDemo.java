package com.java.concept.copyAndWriteArrayList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        List<String> list2 = Arrays.asList("Lemon", "Banana");
        int result = list1.addAllAbsent(list2);
        System.out.println("Elements added: " + result);
        System.out.println(list1);
    }

    public static void main11(String[] args) {
        List<String> numList = new CopyOnWriteArrayList<>();
        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");

        //This thread will iterate the list
        Thread thread1 = new Thread(){
            public void run(){
                try{
                    Iterator<String> i = numList.iterator();
                    while (i.hasNext()){
                        System.out.println(i.next());
                        // Using sleep to simulate concurrency
                        Thread.sleep(1000);
                        if(i.equals("2"))
                        i.remove();
                    }
                }catch(ConcurrentModificationException e){
                    System.out.println("thread1 : Concurrent modification detected       on this list");
                    e.printStackTrace();
                }catch(InterruptedException e){

                }
            }
        };
        thread1.start();

        // This thread will try to add to the collection,
        // while the collection is iterated by another thread.
        Thread thread2 = new Thread(){
            public void run(){
                try{
                    // Using sleep to simulate concurrency
                    Thread.sleep(2000);
                    // adding new value to the shared list
                    numList.add("5");
                   // numList.remove("5");
                    System.out.println("new value added to the list");
                }catch(ConcurrentModificationException e){
                    System.out.println("thread2 : Concurrent modification detected       on the List");
                } catch(InterruptedException e){}
            }
        };
        thread2.start();
    }
}
