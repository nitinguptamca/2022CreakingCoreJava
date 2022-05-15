package com.datastructure.map;

public class TestingCHM {
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> chm = new CustomHashMap<>(5);
        chm.put(1, 1);
        chm.put(2, 3);
        chm.put(3, 2);
        chm.put(4, 4);
        chm.put(5, 5);
        chm.put(6, 7);
        chm.put(7, 8);
        chm.put(8, 9);
        chm.put(13, 9);
        chm.put(18, 9);
        chm.put(23, 9);
        chm.put(9, 10);
        chm.printAll();
        System.out.println("***********************88");
        System.out.println(chm.get(1));
        System.out.println(chm.get(8));
        chm.remove(1);
        chm.remove(8);
        System.out.println();
        System.out.println(chm.get(1));
        System.out.println(chm.get(8));
        System.out.println(chm.get(3));
        System.out.println(chm.get(13));
        System.out.println(chm.get(18));
    }
}
