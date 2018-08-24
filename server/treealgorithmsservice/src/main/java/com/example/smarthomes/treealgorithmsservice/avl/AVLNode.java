package com.example.smarthomes.treealgorithmsservice.avl;

public class AVLNode {

    int element;
    int height;
    AVLNode leftAVLNode;
    AVLNode rightAVLNode;

    public AVLNode(int element) {
        this.element = element;
        leftAVLNode = rightAVLNode = null;
        height = 1;
    }
}
