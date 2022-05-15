package com.datastructure.dll;

import com.datastructure.sll.SingleLinkedList;

import java.util.HashSet;
import java.util.Set;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head, tail;
    private int size;

    public void addAtFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node<T> tmp = head;
            newNode.next = tmp;
            tmp.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node<T> tmp = tail;
            tmp.next = newNode;
            newNode.prev = tmp;
            tail = newNode;
        }
        size++;
    }

    public void addAtMiddle(T value) {
        Node<T> middle = getMiddle(head);
        Node<T> middleNext = middle.next;
        Node<T> newNode = new Node<>(value);
        middle.next = newNode;
        newNode.prev = middle;
        newNode.next = middleNext;
        middleNext.prev = newNode;
        size++;
    }

    private Node<T> getMiddle(Node<T> node) {
        Node<T> slowPointer = node;
        Node<T> fastPointer = node.next;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void addAtPosition(int position, T value) {
        if (0 == position) addAtFirst(value);
        else if (size + 1 == position) addAtLast(value);
        else if (position < 0 || position > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node<T> newNode = new Node<>(value);
            Node<T> tmp = head;
            for (int i = 1; i < position; i++) tmp = tmp.next;
            Node<T> ptr = tmp;
            Node<T> ptrNext = tmp.next;
            ptr.next = newNode;
            newNode.prev = ptr;
            ptrNext.prev = newNode;
            newNode.next = ptrNext;
            size++;
        }
    }

    public void addAtPositionFromLast(int position, T value) {
        if (0 == position) addAtLast(value);
        else if (size + 1 == position) addAtFirst(value);
        else if (position < 0 || position > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node<T> newNode = new Node<>(value);
            Node<T> tmp = tail;
            for (int i = 1; i < position; i++) tmp = tmp.prev;
            Node<T> ptr = tmp;
            Node<T> ptrPrev = tmp.prev;
            ptr.prev = newNode;
            newNode.next = ptr;
            ptrPrev.next = newNode;
            newNode.prev = ptrPrev;
            size++;
        }
    }

    public void removeAtFirst() {
        if (head == null) return;
        else {
            Node<T> tmp = head.next;
            tmp.prev = null;
            head = tmp;
            size--;
        }
    }

    public void removeAtLast() {
        if (head == null) return;
        else {
            Node<T> tmp = tail.prev;
            tmp.next = null;
            tail = tmp;
            size--;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void removeAtPosition(int position) {
        if (0 == position) removeAtFirst();
        else if (size == position) removeAtLast();
        else if (position < 0 || position > size) throw new IndexOutOfBoundsException();
        else {
            Node<T> tmp = head;
            for (int i = 1; i < position; i++) tmp = tmp.next;
            Node<T> ptrPrev = tmp.prev;
            Node<T> ptrNext = tmp.next;
            ptrPrev.next = ptrNext;
            ptrNext.prev = ptrPrev;
            size--;
        }
    }

    public void removeAtMiddle() {
        Node<T> middle = getMiddle(head);
        Node<T> ptrPrev = middle.prev;
        Node<T> ptrNext = middle.next;
        ptrPrev.next = ptrNext;
        ptrNext.prev = ptrPrev;
        size--;
    }

    public void printAll() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void removeFromLastPosition(int position) {
        Node<T> tmp = tail;
        for (int i = 1; i < position; i++) tmp = tmp.prev;
        Node<T> ptrPrev = tmp.prev;
        Node<T> ptrNext = tmp.next;
        ptrPrev.next = ptrNext;
        ptrNext.prev = ptrPrev;
        size--;
    }

    public void removeDuplicate() {
        Node<T> tmp = head;
        while (tmp != null) {
            Node<T> ptr = tmp.next;
            while (ptr != null) {
                if (tmp.value.compareTo(ptr.value) == 0) {
                    deleteNode(ptr);
                }
                ptr = ptr.next;
            }
            tmp = tmp.next;
        }
    }

    private void deleteNode(Node<T> node) {
        if (node.next == null) {
            tail = node;
        } else {
            node.next.prev = node.prev;
        }
        if (node.prev == null) {
            head = node;
        } else {
            node.prev.next = node.next;
        }
    }

    public void printAllBack() {
        Node<T> tmp = tail;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public void sortBubble() {
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            for (Node<T> ptr = tmp.next; ptr != null; ptr = ptr.next) {
                if (tmp.value.compareTo(ptr.value) > 0) {
                    T temp = ptr.value;
                    ptr.value = tmp.value;
                    tmp.value = temp;
                }
            }
        }
    }

    /*
    public void reverseOrder() {
        Node<T> current = head;
        Node<T> previous = null, next1 = null;
        while (current != null) {
            next1 = current.next;
            current.next = previous;
            previous = current;
            current = next1;
        }
        head = previous;
    }

*/

    public void mergeSort() {
        if (head == null) return;
        else {
            head = mergeSort(head);
        }
    }

    private Node<T> mergeSort(Node<T> node) {
        Node<T> middle = getMiddle(node);
        Node<T> nextToMiddle = middle.next;
        middle.next = null;
        Node<T> left = mergeSort(node);
        Node<T> right = mergeSort(nextToMiddle);
        Node<T> sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public void reverseList() {
        if (head == null)
            return;
        Node tmp = null;
        Node current = head;
        while (current != null) {
            tmp = current.prev;
            current.prev = current.next;
            current.next = tmp;
            current = current.prev;
        }
        if (tmp != null) {
            head = tmp.prev;
        }
    }


    public void deleteNode(T key) {
        Node tmp = head;
        while (true) {
            if (key == tmp.value) {
                Node nextV = tmp.next;
                Node prevV = tmp.prev;
                prevV.next = nextV;
                nextV.prev = prevV;
                size--;
                return;
            } else {
                tmp = tmp.next;
            }
        }
    }

    public Node FindBeginning() {
        Node n1 = head;
        Node n2 = head;
        // Find meeting point
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                break;
            }
        }
        // Error check - there is no meeting point, and therefore no loop
        if (n2.next == null) {
            return null;
        }

        /*
         * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from the Loop
         * Start. If they move at the same pace, they must meet at Loop Start.
         */
        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        // Now n2 points to the start of the loop.
        return n2;
    }

    public void removeDuplicateApproach2() {
        Set<T> unique = new HashSet<T>();
        Node<T> tmp=head;
        while (tmp!=null){
            if(!unique.contains(tmp.value)) {
                unique.add(tmp.value);
            }else{
                deleteNode(tmp);
            }
            tmp =tmp.next;
        }
    }

    public void removeDuplicate_old() {
        if (head == null)
            return;
        Node iter = head;

        while (iter != null) {
            Node currNode = iter;
            while (currNode != null && currNode.next != null) {
                if (iter.value == currNode.next.value) {
                    Node nextNode = currNode.next;
                    Node preVNode = currNode.prev;
                    preVNode.next = nextNode;
                    nextNode.prev = preVNode;
                    size--;
                    break;
                }
                currNode = currNode.next;
            }
            iter = iter.next;
        }
    }

    public void removeNode(T data) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.value.compareTo(data) == 0) {
                break;
            }
            tmp = tmp.next;
        }
        Node<T> prevToTmp = tmp.prev;
        Node<T> nextToTmp = tmp.next;
        prevToTmp.next = nextToTmp;
        nextToTmp.prev = prevToTmp;
    }

    private Node<T> sortedMerge(Node<T> left, Node<T> right) {
        Node<T> result = null;
        if(left==null) result= right;
        else if (right==null) result= left;
        else if(left.value.compareTo(right.value) >0){
            result =left;
            result.next = sortedMerge(left.next, right);
        }else{
            result=right;
            result.next=sortedMerge(left ,right.next);
        }
        return result;
    }

    public void quickSort(Node<T> node) {

    }

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
