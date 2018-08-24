package com.example.smarthomes.treealgorithmsservice;

import com.example.smarthomes.treealgorithmsservice.avl.AVLTree;
import com.example.smarthomes.treealgorithmsservice.bst.BinarySearchTree;
import com.example.smarthomes.treealgorithmsservice.maxheap.MaxHeap;
import com.example.smarthomes.treealgorithmsservice.redblack.RedBlackTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreealgorithmsserviceApplication {

    public static void main(String[] args) {

/*        RedBlackTree redBlackTree = new RedBlackTree(Integer.MIN_VALUE);
        redBlackTree.insert(8);
        redBlackTree.insert(3);
        redBlackTree.preorder();*/

/*        int[] a = new int[]{2,4,6};
        MaxHeap maxHeap = new MaxHeap(a);
        maxHeap.insert(12);
        maxHeap.printHeap();*/

/*        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.inOrder();

        System.out.println();
        binarySearchTree.delete(20);
        binarySearchTree.inOrder();*/

        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.preOrder();

        System.out.println();
        avlTree.delete(10);
        avlTree.preOrder();

        SpringApplication.run(TreealgorithmsserviceApplication.class, args);
    }
}
