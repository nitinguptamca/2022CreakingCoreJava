package com.hardQuestion.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> sss = new ArrayList<>();
        sss.add(1);
        sss.add(2);
        sss.add(4);

        for (Integer a:sss ) {
           if(a==1){
              // sss.add(3);  //java.util.ConcurrentModificationException
               sss.remove(1);  //java.util.ConcurrentModificationException
           }
           // sss.remove(20);
        }
        System.out.println(sss);
    }
}
