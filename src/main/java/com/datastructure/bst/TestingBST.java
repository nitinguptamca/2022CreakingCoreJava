package com.datastructure.bst;

public class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(8);
        bst.insert(7);
        bst.insert(20);
        bst.insert(13);
        bst.insert(17);
        bst.insert(11);
        bst.inOrderTraverse(bst.getRoot());
        System.out.println();
        // bst.preOrderTraverse(bst.getRoot());
        // System.out.println();
        //  bst.postOrderTraverse(bst.getRoot());
        //  System.out.println();
        //  bst.delete(5);
        bst.levelOrderTraversal(bst.getRoot());
        System.out.println("\n"+bst.height_approach2(bst.getRoot()));
        System.out.println("\n  height "+bst.height(bst.getRoot()));
        System.out.println("\n count node  :: "+bst.countNode(bst.getRoot()));
        System.out.println("**********************");
        bst.traverseZigZag(bst.getRoot());
    }
}
