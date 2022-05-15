package com.java.concept.copyAndWriteArrayList;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 * This program demonstrates how CopyOnWriteArrayList works.
 *
 * @author www.codejava.net
 */
public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        new WriteThread("Writer", list).start();

        new ReadThread("Reader", list).start();

    }
}


class WriteThread extends Thread {

    private List<Integer> list;

    public WriteThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    public void run() {
        int count = 6;

        while (true) {

            try {

                Thread.sleep(5000);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            list.add(count++);

            System.out.println(super.getName() + " done");
        }
    }
}


class ReadThread extends Thread {
    private List<Integer> list;

    public ReadThread(String name, List<Integer> list) {
        this.list = list;
        super.setName(name);
    }

    public void run() {

        while (true) {

            String output = "\n" + super.getName() + ":";

            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                output += " " + next;

                // fake processing time
                try {

                    Thread.sleep(10);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(output);
        }
    }
}