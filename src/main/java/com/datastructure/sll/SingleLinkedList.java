package com.datastructure.sll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SingleLinkedList<T extends Comparable<T>> {

    private Node<T> head, tail;

    public Node<T> getHead() {
        return head;
    }

    int size;


    public void quickSort(Node<T> first) {
        Node<T> lastNode = getLastNode(first);
        // Call the recursive QuickSort
        quickSort(first, lastNode);
    }

    private Node<T> getLastNode(Node<T> node) {
        while (node.next != null)
            node = node.next;
        return node;
    }


    private void quickSort(Node<T> firstNode, Node<T> lastNode) {
        if (firstNode != lastNode && firstNode != lastNode.next) {
            Node<T> temp = partition(firstNode, lastNode);
            quickSort(firstNode, temp);
            quickSort(temp.next, lastNode);
        }
    }

    public Node<T> partition(Node<T> first, Node<T> last) {

        Node<T> p = first;
        Node<T> ptr = p.next;

        while (ptr != null) {
            if (p.data.compareTo(ptr.data) > 0) {
                T pivot = p.data;
                p.data = ptr.data;
                ptr.data = p.next.data;
                p.next.data = pivot;
                p = p.next;
            }
            ptr = ptr.next;
        }
        return p;
    }


    public void addAtFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node<T> tmp = head;
            newNode.next = tmp;
            head = newNode;
        }
        size++;
    }

    public void addAtLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node<T> tmp = tail;
            tmp.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtMiddle(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> middleNode = getMiddleNode();
        Node<T> middleNodeNext = middleNode.next;
        middleNode.next = newNode;
        newNode.next = middleNodeNext;
        size++;
    }

    private Node<T> getMiddleNode() {
        Node<T> slowPointer = head;
        Node<T> fastPointer = head.next;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    private Node<T> getMiddleNode(Node<T> h) {
        Node<T> slowPointer = h;
        Node<T> fastPointer = h.next;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void addAtPosition(int position, T data) {
        if (0 == position) addAtFirst(data);
        else if (size + 1 == position) addAtLast(data);
        else if (position < 0 || position > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> tmp = head;
            for (int i = 1; i < position; i++) tmp = tmp.next;
            Node<T> ptr = tmp;
            Node<T> ptrNext = tmp.next;
            ptr.next = newNode;
            newNode.next = ptrNext;
            size++;
        }
    }

    public void addAtPositionFromLast(int positionFromLast, T data) {
        if (0 == positionFromLast) addAtLast(data);
        else if (size + 1 == positionFromLast) addAtFirst(data);
        else if (positionFromLast < 0 || positionFromLast > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> t = head;
            Node<T> s = head;
            int count = 1;
            while (t != null) {
                if (count <= positionFromLast) {
                    t = t.next;
                    count++;
                } else {
                    t = t.next;
                    s = s.next;
                }
            }
            Node<T> ptr = s;
            Node<T> ptrNext = s.next;
            ptr.next = newNode;
            newNode.next = ptrNext;
            size++;
        }
    }

    public void removeAtFirst() {
        if (head == null) return;
        else {
            Node tmp = head.next;
            head = tmp;
            size--;
        }
    }

    public void removeAtLast() {
        if (head == null) return;
        else {
            Node<T> tmp = head;
            boolean flag = false;
            while (tmp.next != null && tmp.next.next != null) {
                tmp = tmp.next;
                flag = true;
            }
            if (flag) {
                tmp.next = tmp.next.next;
            } else {
                System.out.println("when only 2 element present ");
                if (tmp.next != null) tmp.next = tmp.next.next;
                else head = null;
            }
            size--;
        }
    }

    public void removeAtPosition(int position) {
        if (head == null) return;
        else if (0 == position) removeAtFirst();
        else if (size == position) removeAtLast();
        else if (position < 0 || position > size) throw new IndexOutOfBoundsException();
        else {
            Node<T> tmp = head;
            for (int i = 1; i < position; i++) tmp = tmp.next;
            tmp.next = tmp.next.next;
            size--;
        }
    }

    public void removeAtMiddle() {
        Node<T> middle = getBeforeMiddleNode();
        if (middle.next == null) {
            head = null;
        } else {
            middle.next = middle.next.next;
        }
        size--;
    }

    private Node<T> getBeforeMiddleNode() {
        if (head == null) return null;
        Node<T> slowPointer = head;
        if (slowPointer.next == null) return slowPointer;
        Node<T> fastPointer = head.next.next;
        if (fastPointer == null) return slowPointer;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void removeFromLastPosition(int position) {
        if (position == 0) removeAtLast();
        else if (position == size) removeAtFirst();
        else if (position < 0 || position > size) throw new IndexOutOfBoundsException();
        else {
            Node<T> t = head;
            Node<T> s = head;
            int count = 0;
            while (t != null) {
                if (count <= position) {
                    t = t.next;
                    count++;
                } else {
                    t = t.next;
                    s = s.next;
                }
            }
            s.next = s.next.next;
            size--;
        }
    }

    public void removeDuplicate() {
        if (head == null) return;
        Node<T> tmp = head;
        while (tmp != null) {
            Node<T> ptr = tmp;
            while (ptr != null && ptr.next != null) {
                if (tmp.data.compareTo(ptr.next.data) == 0) {
                    ptr.next = ptr.next.next;
                } else if (ptr.data.compareTo(ptr.next.data) == 0) {
                    ptr.next = ptr.next.next;
                }
                ptr = ptr.next;
            }
            tmp = tmp.next;
        }

    }

    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void sortBubble() {
        if (head == null) return;
        for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
            for (Node<T> ptr = tmp.next; ptr != null; ptr = ptr.next) {
                if (tmp.data.compareTo(ptr.data) > 0) {
                    T temp = ptr.data;
                    ptr.data = tmp.data;
                    tmp.data = temp;
                }
            }
        }
    }

    public void reverseOrder() {
        if (head == null) return;
        Node current = head;
        Node previous = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void mergeSort() {
        if (head == null) return;
        head = mergeSort(head);
    }

    private Node mergeSort(Node<T> h) {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }
        // get the middle of the list
        Node<T> middle = getMiddleNode(h);
        Node<T> nextofmiddle = middle.next;
        // set the next of middle node to null
        middle.next = null;
        // Apply mergeSort on left list
        Node<T> left = mergeSort(h);
        // Apply mergeSort on right list
        Node<T> right = mergeSort(nextofmiddle);
        // Merge the left and right lists
        Node<T> sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    protected Node<T> sortedMerge(Node<T> a, Node<T> b) {
        Node<T> result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data.compareTo(b.data) > 0) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public void mergeList(Node<T> head, Node<T> head1) {
        Node<T> t = tail;
        Node<T> s = head1;

        while (s != null) {
            t.next = s;
            tail = s;
            s = s.next;
            size++;
            if (t.next == s.next) break;
        }
    }

    /**
     * Input: 20->4->54->6->NULL <br>
     * Output: No loop is detected. <br>
     * Explanation: <br>
     * While traversing the linked list, we reach the end of the linked list. Therefore, no loop is present in the linked list.
     * <p></p>
     * Input: 20->4->5->10->20 <br>
     * Output: Loop detected. <br>
     * Explanation: <br>
     * While traversing the linked list, reaching the node with value 10, it is linked with the head node, which depicts a loop in the linked list. Therefore, a loop is present in the linked list.
     */

    public boolean detectCycleInLinkedList(Node<T> node) {
        if (head == null) {
            return false;
        } else {
            HashSet<Node> visited = new HashSet<Node>();
            boolean flag = false;
            Node tmp = head;
            while (tmp != null) {
                if (visited.contains(tmp))
                    return true;
                visited.add(tmp);
                tmp = tmp.next;
            }
            return false;
        }
    }

    public boolean detectCycleInLinkedList_app2(Node<T> node) {
        if (head == null) {
            return false;
        } else {
            Map<Node, Boolean> visited = new HashMap<>();
            boolean flag = false;
            Node tmp = head;
            while (tmp != null) {
                if (visited.containsKey(tmp))
                    return true;
                visited.put(tmp, true);
                tmp = tmp.next;
            }
            return false;
        }
    }

    private static class Node<T extends Comparable<T>> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{ " + data + '}';
        }
    }
}
