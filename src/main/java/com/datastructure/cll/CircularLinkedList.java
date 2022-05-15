package com.datastructure.cll;


public class CircularLinkedList {

    public static int ZERO = 0;
    int size;
    Node head, tail;

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addAtFirst(3);
        list.addAtFirst(2);
        list.addAtFirst(1);
        list.addAtLast(4);
        list.addAtLast(5);
        list.addAtLast(6);
        list.addAtPosition(2, 8);
        list.addAtPosition(5, 7);
        list.addAtPosition(0, 9);
        list.addAtPosition(4, 9);
        list.addAtLast(4);
        list.addAtLast(5);
        list.addAtLast(6);
        list.addAtPosition(2, 4);
        list.addAtPosition(5, 2);
        list.addAtPosition(0, 5);
        list.addAtPosition(4, 3);
        list.printAll();
    }

    private void removeAtPosition(int position) {
        if (ZERO == position) removeAtFirst();
        else if (size == position) removeAtLast();
        else if (position > size) throw new IndexOutOfBoundsException();
        else {
            Node tmp = head;
            for (int i = 0; i < size; i++) {
                if (i == position - 1) {
                    tmp.next = tmp.next.next;
                    size--;
                    return;
                }
                tmp = tmp.next;
            }
        }
    }

    private void removeAtLast() {
        if (head == null) throw new IndexOutOfBoundsException();
        Node tmp = head;
        do {
            if (tmp.next.next == tail) {
                tail = tmp.next;
                tail.next = head;
                size--;
                return;
            }
            tmp = tmp.next;
        } while (tmp != head);
    }

    private void removeAtFirst() {
        if (head == null) throw new IndexOutOfBoundsException();
        Node tmp = head;
        head = tmp.next;
        tail.next = head;
        size--;
    }

    private void addAtPosition(int position, int data) {
        Node node = new Node(data);
        if (ZERO == position) addAtFirst(data);
        else if (size + 1 == position) addAtLast(data);
        else if (position > size) throw new IndexOutOfBoundsException();
        else {
            Node tmp = head;
            for (int i = 0; i < size; i++) {
                if (i == position - 1) {
                    Node ptr = tmp.next;
                    tmp.next = node;
                    node.next = ptr;
                    size++;
                    return;
                }
                tmp = tmp.next;
            }
        }
    }

    private void addAtLast(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            node.next = head;
        }
    }

    private void printAll() {
        Node tmp = head;
        do {
            System.out.print(tmp.data + ", ");
            tmp = tmp.next;
        } while (tmp != head);
        System.out.println("\n size" + size);
    }

    private void addAtFirst(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            Node tmp = head;
            node.next = tmp;
            head = node;
            tail.next = head;
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}