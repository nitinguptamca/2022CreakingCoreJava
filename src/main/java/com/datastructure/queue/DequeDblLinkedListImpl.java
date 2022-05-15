package com.datastructure.queue;

public class DequeDblLinkedListImpl<T> {

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + value + '}';
        }
    }

    private Node<T> front;
    private Node<T> rear;

    public void insertFront(T item) {
        //add element at the beginning of the queue
        System.out.println("adding at front: " + item);
        Node<T> node = new Node<T>(item);
        if (front == null) {
            front = rear = node;
        } else {
            Node<T> tmp = front;
            node.next = tmp;
            tmp.prev = node;
            front = node;
        }
    }

    public void insertRear(T item) {
        //add element at the beginning of the queue
        System.out.println("adding at Rear: " + item);
        Node<T> node = new Node<T>(item);
        if (front == null) {
            front = rear = node;
        } else {
            Node<T> tmp = rear;
            tmp.next = node;
            node.prev = tmp;
            rear = node;
        }
    }

    public void removeFront() {
        if (front == null) {
            System.out.println("Deque underflow!! unable to remove.");
            return;
        } else {
            Node<T> tmpFront = front.next;
            if (tmpFront != null)
                tmpFront.prev = null;
            if (tmpFront == null)
                rear = null;
            System.out.println("removed from front: " + front.value);
            front = tmpFront;
        }
    }

    public void removeRear() {
        if (rear == null) {
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
//remove an item from the beginning of the queue
        Node<T> tmpRear = rear.prev;
        if (tmpRear != null)
            tmpRear.next = null;
        if (tmpRear == null)
            front = null;
        System.out.println("removed from rear: " + rear.value);
        rear = tmpRear;
    }

    public static void main(String a[]) {
        DequeDblLinkedListImpl<Integer> deque = new DequeDblLinkedListImpl<Integer>();
        deque.insertFront(34);
        deque.insertFront(67);
        deque.insertFront(29);
        deque.insertFront(765);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.insertRear(43);
        deque.insertRear(83);
        deque.insertRear(84);
        deque.insertRear(546);
        deque.insertRear(356);
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
    }

}
