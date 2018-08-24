package com.example.smarthomes.treealgorithmsservice.redblack;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree {

    private RedBlackNode currentNode;
    private RedBlackNode parentNode;
    private RedBlackNode grandParent;
    private RedBlackNode greatParent;
    private RedBlackNode rootNode;
    private static RedBlackNode nullNode;

    static final int BLACK = 1;
    static final int RED = 0;

    static {
        nullNode = new RedBlackNode(0);
        nullNode.leftNode = nullNode;
        nullNode.rightNode = nullNode;
    }

    public RedBlackTree(int negInf) {
        rootNode = new RedBlackNode(negInf);
        rootNode.leftNode = nullNode;
        rootNode.rightNode = nullNode;
    }

    public boolean isEmpty() {
        return rootNode.rightNode == nullNode;
    }

    private RedBlackNode rotateWithLeftChild(RedBlackNode leftChild) {
        RedBlackNode leftChildAux = leftChild.leftNode;
        leftChild.leftNode = leftChildAux.rightNode;
        leftChildAux.rightNode = leftChild;
        return leftChildAux;
    }

    private RedBlackNode rotateWithRightChild(RedBlackNode rightChild) {
        RedBlackNode rightChildAux = rightChild.rightNode;
        rightChild.rightNode = rightChildAux.leftNode;
        rightChildAux.leftNode = rightChildAux;
        return rightChildAux;
    }

    private RedBlackNode rotate(int item, RedBlackNode parentNode) {
        if(item < parentNode.element) {
            return parentNode.leftNode = item < parentNode.leftNode.element ? rotateWithLeftChild(parentNode.leftNode) : rotateWithRightChild(parentNode.leftNode);
        }
        else {
            return parentNode.rightNode = item < parentNode.rightNode.element ? rotateWithLeftChild(parentNode.rightNode) : rotateWithRightChild(parentNode.rightNode);
        }
    }

    private void handleReorient(int item) {

        /* Try to recolor */

        currentNode.color = RED;
        currentNode.leftNode.color = BLACK;
        currentNode.rightNode.color = BLACK;

        if(parentNode.color == RED) {
            grandParent.color =  RED;

            if(item < grandParent.element != item < parentNode.element) {
                parentNode = rotate(item, grandParent);
            }
            currentNode = rotate(item, greatParent);
            currentNode.color = BLACK;
        }
        rootNode.rightNode.color = BLACK;
    }

    public void insert(int item) {
        currentNode = parentNode = grandParent = rootNode;
        nullNode.element = item;

        while(currentNode.element != item) {

            greatParent = grandParent;
            grandParent = parentNode;
            parentNode = currentNode;

            currentNode = item < currentNode.element ? currentNode.leftNode : currentNode.rightNode;

            if(currentNode.leftNode.color == RED && currentNode.rightNode.color == RED) {
                handleReorient(item);
            }
        }
        if(currentNode != nullNode) {
            return;
        }
        currentNode = new RedBlackNode(item, nullNode, nullNode);

        if(item < parentNode.element) {
            parentNode.leftNode = currentNode;
        }
        else {
            parentNode.rightNode = currentNode;
        }
        handleReorient(item);
    }

    public void preorder()
    {
        preorder(rootNode.rightNode);
    }
    private void preorder(RedBlackNode r)
    {
        if (r != nullNode)
        {
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.println(r.element +""+c+" ");
            preorder(r.leftNode);
            preorder(r.rightNode);
        }
    }

}
