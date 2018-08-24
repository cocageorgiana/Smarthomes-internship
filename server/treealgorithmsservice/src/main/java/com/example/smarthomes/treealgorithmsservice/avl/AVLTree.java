package com.example.smarthomes.treealgorithmsservice.avl;

public class AVLTree {

    private AVLNode root;

    /**
     * Utility function to get height of the tree
     * @param node The start node
     * @return
     */
    int height(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * Utility function to get maximum of 2 integers
     * @param a first integer
     * @param b second integer
     * @return
     */

    int max(int a, int b) {
        return (a>b) ? a : b;
    }

    /**
     * Utility function to right rotate subtree rooted with y
     * @param y The root of the subtree for which we want to make the rotation
     * @return
     */

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.leftAVLNode;
        AVLNode t = x.rightAVLNode;

        x.rightAVLNode = y;
        y.leftAVLNode = t;

        y.height = max(height(y.leftAVLNode), height(y.rightAVLNode)) + 1;
        x.height = max((height(x.leftAVLNode)), height(x.rightAVLNode)) + 1;

        return x;
    }

    /**
     * Utility function to left rotate subtree rooted with x
     * @param x The root of the subtree for which we want to make the rotation
     * @return
     */

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.rightAVLNode;
        AVLNode t = y.leftAVLNode;

        y.leftAVLNode = x;
        x.rightAVLNode = t;

        x.height = max(height(x.leftAVLNode), height(x.rightAVLNode)) + 1;
        y.height = max((height(y.leftAVLNode)), height(y.rightAVLNode)) + 1;

        return y;
    }

    /**
     * Utility function to get the balance factor of a node
     * @param node The node for which we want to get the balance factor
     * @return
     */

    int getBalance(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return height(node.leftAVLNode) - height(node.rightAVLNode);
    }

    AVLNode insert(AVLNode node, int element) {
        if(node == null) {
            return new AVLNode(element);
        }

        if(element < node.element) {
            node.leftAVLNode = insert(node.leftAVLNode, element);
        }
        else if(element > node.element) {
            node.rightAVLNode = insert(node.rightAVLNode, element);
        }
        else {
            return node;
        }

        node.height = 1 + max(height(node.leftAVLNode), height(node.rightAVLNode));

        int balance =  getBalance(node);

        // Left left case
        if(balance > 1 && element < node.leftAVLNode.element) {
            return rightRotate(node);
        }

        //Right right case
        if(balance < -1 && element > node.rightAVLNode.element) {
            return leftRotate(node);
        }

        //Left right case
        if(balance > 1 && element > node.leftAVLNode.element) {
            node.leftAVLNode = leftRotate(node.leftAVLNode);
            return rightRotate(node);
        }

        //Right left case
        if(balance < -1 && element < node.rightAVLNode.element) {
            node.rightAVLNode = rightRotate(node.rightAVLNode);
            return leftRotate(node);
        }
        return node;
    }

    public void insert(int element) {
        root = insert(root, element);
    }

    /**
     * Given a non-empty BST return the node with the minimum key value found in that tree
     * @param node The root node of the tree
     * @return
     */

    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        while(current.leftAVLNode != null) {
            current = current.leftAVLNode;
        }
        return current;
    }

    AVLNode deleteNode(AVLNode root, int element) {
        if(root == null) {
            return root;
        }

        if(element < root.element) {
            root.leftAVLNode = deleteNode(root.leftAVLNode, element);
        }
        else if(element > root.element) {
            root.rightAVLNode = deleteNode(root.rightAVLNode, element);
        }
        else {
            if(root.leftAVLNode == null || root.rightAVLNode == null) {
                AVLNode tempNode = null;
                if(tempNode == root.leftAVLNode) {
                    tempNode = root.leftAVLNode;
                }
                else {
                    tempNode = root.leftAVLNode;
                }
                if(tempNode == null) {
                    tempNode = root;
                    root = null;
                }
                else {
                    root = tempNode;
                }
            }
            else {
                AVLNode tempNode = minValueNode(root.rightAVLNode);
                root.element = tempNode.element;
                root.rightAVLNode = deleteNode(root.rightAVLNode, tempNode.element);
            }
        }

        if(root == null) {
            return root;
        }
        root.height = max(height(root.leftAVLNode), height(root.rightAVLNode)) + 1;

        int balance = getBalance(root);

        if(balance > 1 && getBalance(root.leftAVLNode) >= 0) {
            return rightRotate(root);
        }

        if(balance < -1 && getBalance(root.rightAVLNode) <= 0) {
            return leftRotate(root);
        }

        if(balance < -1 && getBalance(root.rightAVLNode) > 0) {
            root.rightAVLNode = rightRotate(root.rightAVLNode);
            return leftRotate(root);
        }
        return root;
    }

    public void delete(int element) {
        root = deleteNode(root, element);
    }

    private void preOrder(AVLNode node) {
        if(node != null) {
            System.out.println(node.element + " ");
            preOrder(node.leftAVLNode);
            preOrder(node.rightAVLNode);
        }
    }

    public void preOrder() {
        preOrder(root);
    }


}
