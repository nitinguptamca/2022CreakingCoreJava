package com.datastructure.sll;

import java.util.List;

public class TestingSLL {




    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addAtFirst(10);
        list.addAtLast(11);
        list.addAtFirst(20);
        list.addAtFirst(30);
        list.addAtFirst(40);
        list.addAtFirst(11);
        list.printAll();
        list.delete(40);
        list.printAll();
       // System.out.println(list.detectCycleInLinkedList(list.getHead()));
       /* list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(40);
        list.addAtLast(10);
        list.addAtLast(11);*/
        //   list.addAtMiddle(11);
        //  list.addAtMiddle(55);
        //  list.addAtPosition(2, 22);
        //   list.addAtPosition(9, 99);
        //   list.addAtPositionFromLast(2, 25);
        //   list.addAtPositionFromLast(9, 88);
        /// list.removeAtFirst();
        /// list.removeAtFirst();
        ///  list.removeAtLast();
        //   list.removeAtLast();
        // list.removeAtPosition(3);
        //list.printAll();
        //list.removeAtPosition(7);
        //  list.printAll();
        // list.removeAtMiddle();
        ///  list.printAll();
        // ///  list.removeAtMiddle();
        //  list.printAll();
        ///  list.removeAtMiddle();
        //  list.printAll();
        //  list.removeAtMiddle();
        // list.printAll();
        //list.removeFromLastPosition(2);
        // list.printAll();
        ///list.removeFromLastPosition(2);
        //  list.printAll();
        //  list.removeDuplicate();
        // list.printAll();
        //list.sortBubble();
        //  list.printAll();
        //list.reverseOrder();
        // list.printAll();
        //list.mergeSort();

        /// SingleLinkedList.Node<Integer> vvv = list.sortedMerge(list.getHead(), list.getHead());
        ///  list.quickSort(list.getHead());
        // list.printAll();



    }
}
