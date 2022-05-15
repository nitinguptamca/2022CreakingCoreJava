package com.datastructure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        if (node.leftChild != null) preOrderTraverse(node.leftChild);
        if (node.rightChild != null) preOrderTraverse(node.rightChild);
        System.out.print(node);
    }

    //root-left-right
    public void preOrderTraverse(Node<T> node) {
        System.out.print(node);
        if (node.leftChild != null) preOrderTraverse(node.leftChild);
        if (node.rightChild != null) preOrderTraverse(node.rightChild);
    }

    public void delete(T data) {
        if (root == null) return;
        delete(data, root);
    }

    public void delete(T deleteData, Node<T> node) {
        if (node == null) return;
        else if (node.data.compareTo(deleteData) > 0) {
            delete(deleteData, node.leftChild);
        } else if (node.data.compareTo(deleteData) < 0) {
            delete(deleteData, node.rightChild);
        } else {
            System.out.println("data is present in the BST");
            //Node<T> parent= node.parentNode;
            if (node.leftChild == null && node.rightChild == null) {
                System.out.println("case 1 when left child and right Child both are null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = null;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = null;
                } else if (parent == null) {
                    root = null;
                } else {
                }
                //Node must be gc
                node = null;
            } else if (node.leftChild != null && node.rightChild == null) {
                System.out.println("case 2 when left child not null and right Child both are null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.leftChild;
                } else if (parent == null) {
                    root =parent.leftChild;
                } else {
                }
                node.leftChild.parentNode=parent;
                //node must be GC
                node=null;
            } else if (node.leftChild == null && node.rightChild != null) {
                System.out.println("case 2 when left child  null and right Child both are not null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.rightChild;
                } else if (parent == null) {
                    root =parent.rightChild;
                } else {
                }
                node.rightChild.parentNode=parent;
                //node must be GC
                node=null;

            } else {
                System.out.println("case 4 when left child and right Child both are not null");
                Node<T> predecessor = getPredecessor(node.rightChild);
                T temp = predecessor.data;
                predecessor.data = node.data;
                node.data = temp;
                delete(deleteData, predecessor);

            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.leftChild!=null) return getPredecessor(node.leftChild);
        return node;
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

    public Node<T> getMax(Node<T> node) {
        return node.rightChild==null ?node:getMax(node.rightChild);
    }

    public Node<T> getMin(Node<T> node) {
        return node.leftChild==null ? node: getMin(node.leftChild);
    }

    public void levelOrderTraversal(Node<T> node) {
        if (node == null)
            return;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node node1 = nodes.remove();
            System.out.print("  " + node1);
            if (node1.leftChild != null) {
                nodes.add(node1.leftChild);
            }
            if (node1.rightChild != null) {
                nodes.add(node1.rightChild);
            }
        }

    }

    int height_approach2(Node<T> node){
        if(node==null) return 0;
        return Math.max(height_approach2(node.leftChild), height_approach2(node.rightChild)) + 1;
    }

    int height(Node<T> node) {
        if (node == null)
            return 0;
        else {

            /* compute the height of each subtree */
            int lheight = height(node.leftChild);
            int rheight = height(node.rightChild);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public int  countNode(Node<T> node) {
        if(node==null) return 0;
        else{
            int l =1;
            l +=countNode(node.leftChild);
            l+=countNode(node.rightChild);
            return l;
        }
    }

    public void traverseZigZag(Node<T> node) {
        if (node == null)     return;
        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(node);
        boolean leftToRight = true;
        while (!currentLevel.isEmpty()) {
            // pop out of stack
            Node tmp = currentLevel.pop();

            // print the data in it
            System.out.print(tmp);

            // store data according to current
            // order.
            if (leftToRight) {
                if (tmp.leftChild != null) {
                    nextLevel.push(tmp.leftChild);
                }

                if (tmp.rightChild != null) {
                    nextLevel.push(tmp.rightChild);
                }
            } else {
                if (tmp.rightChild != null) {
                    nextLevel.push(tmp.rightChild);
                }

                if (tmp.leftChild != null) {
                    nextLevel.push(tmp.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

    }


    public void printLeafNode(Node<T> node) {
        if(node == null) return;
        if(node.leftChild==null && node.rightChild==null)
            System.out.print(node);
        if(node.leftChild!=null) printLeafNode(node.leftChild);
        if(node.rightChild!=null) printLeafNode(node.rightChild);
    }


    public boolean searchData(T data) {
        if (root == null) return false;
        else {
            //return searchData(data, root);
            return searchDataApproach2(data, root);
        }
    }

    private boolean searchDataApproach2(T data, Node<T> node) {
        if(node==null) return false;
        else if(node.data.compareTo(data)==0) return true;
        else return node.data.compareTo(data) >0 ? searchDataApproach2(data ,node.leftChild) : searchDataApproach2(data ,node.rightChild);
    }

    private boolean searchData(T data, Node<T> node) {
        if (node == null) return false;
        if (node.data.compareTo(data) > 0) {
            return searchData(data, node.leftChild);
        } else if (node.data.compareTo(data) < 0) {
            return searchData(data, node.rightChild);
        } else if (node.data.compareTo(data) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node<T> findSmallest(Node<T>  node) {
        return node.leftChild == null ? node : findSmallest(node.leftChild);
    }

    public Node<T> getLargerst(Node<T> node) {
        return node.rightChild == null ? node : getLargerst(node.rightChild);
    }

    public Node<T> mirror(Node<T> node) {
        if(node ==null) return node;
        Node<T> left = mirror(node.leftChild);
        Node<T> right = mirror(node.rightChild);
        node.leftChild=right;
        node.rightChild=left;
        return node;
    }

    public boolean  isIdenticalTree(Node<T> a  ,Node<T> b) {
        if(a==null  && b ==null) return true;
        else if(a==null && b !=null) return false;
        else if(a!=null && b ==null) return false;
        else{
            return (a.data ==b.data && isIdenticalTree( a.leftChild ,b.leftChild) && isIdenticalTree(a.rightChild, b.rightChild));
        }
    }

    public boolean isFordableTree(Node<T> node) {
        if(node==null) return true;
        return check(node.leftChild ,node.rightChild);
    }

    private boolean check(Node<T> left ,Node<T> right) {
        if(left==null && right==null) return true;
        else if(left!=null && right==null) return false;
        else if(left==null && right!=null) return false;
        else{
            return check(left.leftChild ,right.rightChild) &&
                    check(left.rightChild ,right.leftChild);
        }
    }

    public boolean  isStructureSame(Node<Integer> a, Node<Integer> b) {
        if(a==null && b==null) return true;
        else if (a != null && b != null
                && isStructureSame(a.leftChild, b.leftChild)
                && isStructureSame(a.rightChild, b.rightChild)) return true;
        else return false;
    }



}
