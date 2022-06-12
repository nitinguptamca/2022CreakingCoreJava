package com.datastructure.sll2.sll;

public class TestingSLL {




    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addAtFirst(10);
        list.addAtLast(11);
        list.addAtFirst(20);
        list.addAtFirst(30);
        list.addAtFirst(40);
        list.addAtFirst(11);
        System.out.println(list.detectCycleInLinkedList(list.getHead()));
        list = CustomCollection.unModifiableList(list);
        list.addAtFirst(10);
    }
}
