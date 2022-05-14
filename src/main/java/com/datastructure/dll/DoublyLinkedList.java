package com.datastructure.dll;

public class DoublyLinkedList<T extends Comparable<T>> {

    Node<T> head ,tail;

    private static class Node<T extends Comparable<T>> {
        T value;
        Node<T> next, prev;

        Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "{ " + value + '}';
        }
    }
}
