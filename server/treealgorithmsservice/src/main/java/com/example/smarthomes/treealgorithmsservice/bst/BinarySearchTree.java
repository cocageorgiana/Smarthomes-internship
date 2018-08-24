package com.example.smarthomes.treealgorithmsservice.bst;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new node in the tree
     * @param root The root of the tree needed in order to make the necessarily comparisons and find out the position in which we insert the new node
     * @param element The actual key that we want to insert in the tree
     * @return
     */

    Node insert(Node root, int element) {
        if(root == null) {
            root = new Node(element);
            return root;
        }

        if(element < root.element) {
            root.leftNode = insert(root.leftNode, element);
        }
        else if(element > root.element) {
            root.rightNode = insert(root.rightNode, element);
        }
        return root;
    }

    public void insert(int element) {
        root = insert(root, element);
    }

    /**
     * Given a non-empty BST return the node with minimum key found in that tree
     * @param root The root of the non-empty BST tree for which we want to find out the minimum key
     * @return The minimum key found
     */

    int minValue(Node root) {

        int minValue = root.element;
        while(root.leftNode != null) {
            minValue = root.leftNode.element;
            root = root.leftNode;
        }
        return minValue;
    }

    /**
     * Delete a key from the tree
     * @param root The root element of the tree
     * @param element The actual key that we want to delete
     * @return The updated root of the tree
     */

    Node delete(Node root, int element) {
        if(root == null) {
            return root;
        }
        if(element < root.element) {
            root.leftNode = delete(root.leftNode, element);
        }
        else if(element < root.element) {
            root.rightNode = delete(root.rightNode, element);
        }
        else {
            if(root.leftNode == null) {
                return root.rightNode;
            }
            else if(root.rightNode == null) {
                return root.leftNode;
            }
            root.element = minValue(root.rightNode);
            root.rightNode = delete(root.rightNode, root.element);
        }
        return root;
    }

    public void delete(int element) {
        root = delete(root, element);
    }

    /**
     * Utility function that makes a In Order traversal and prints the elements
     * @param root The root of the tree for which we make the in order traversal
     */

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.leftNode);
            System.out.println(root.element);
            inOrder(root.rightNode);
        }
    }

    public void inOrder() {
        inOrder(root);
    }
}
