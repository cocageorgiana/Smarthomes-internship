package com.example.smarthomes.treealgorithmsservice.redblack;

public class RedBlackNode {

    RedBlackNode leftNode;
    RedBlackNode rightNode;
    int element;
    int color;

    public RedBlackNode(int element) {
        this(element, null, null);
    }

    public RedBlackNode(int element, RedBlackNode leftNode, RedBlackNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.element = element;
        color = 1;
    }

}
