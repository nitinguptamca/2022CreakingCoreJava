package com.datastructure.bst;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        //base case node is null
        if (node == null) return;
        if (node.data.compareTo(data) > 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(data, node);
            } else {
                insert(data, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(data, node);
            } else {
                insert(data, node.rightChild);
            }
        }
    }
    //left-right-root
    public void postOrderTraverse(Node<T> node) {
        if(node.leftChild!=null) preOrderTraverse(node.leftChild);
        if(node.rightChild!=null)preOrderTraverse(node.rightChild);
        System.out.print(node);
    }

    //root-left-right
    public void preOrderTraverse(Node<T> node) {
        System.out.print(node);
        if(node.leftChild!=null) preOrderTraverse(node.leftChild);
        if(node.rightChild!=null)preOrderTraverse(node.rightChild);
    }

    private static class Node<T extends Comparable<T>> {
        Node<T> leftChild, rightChild, parentNode;
        T data;

        Node(T data, Node<T> parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "{" + data + '}';
        }
    }

    //left-root-right
    public void inOrderTraverse(Node<T> node) {
        if (node.leftChild != null) inOrderTraverse(node.leftChild);
        System.out.print(node);
        if (node.rightChild != null) inOrderTraverse(node.rightChild);
    }

}
