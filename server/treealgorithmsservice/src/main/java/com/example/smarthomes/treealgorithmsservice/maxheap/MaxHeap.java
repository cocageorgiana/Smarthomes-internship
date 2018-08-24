package com.example.smarthomes.treealgorithmsservice.maxheap;

import java.util.Arrays;

public class MaxHeap {

    int[] heap;
    int size;

    public MaxHeap(int[] heap) {
        this.size = heap.length;
        this.heap = Arrays.copyOf(heap, size);
        buildMaxHeap();
    }

    /**
     * Makes the array satisfy the max heap property starting from {@param index} till the end of the array
     * @param index The index from which we want to start making the array satisfy the max heap property
     */

    public void maxHeapify(int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if(leftIndex < size && heap[index] < heap[leftIndex]) {
            largest = leftIndex;
        }
        if(rightIndex < size && heap[largest] < heap[rightIndex]) {
            largest = rightIndex;
        }

        if(largest != index) {
            int aux = heap[index];
            heap[index] = heap[largest];
            heap[largest] = aux;
            maxHeapify(largest);
        }
    }

    /**
     * Converts the array to a max heap
     */
    public void buildMaxHeap() {
        for(int i= size / 2 - 1; i>=0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Insert a new element into the heap satisfying the heap property
     * @param element The element which we want to be inserted in the heap
     */

    public void insert(int element) {
        heap = Arrays.copyOf(heap, size+1);
        int i = size;
        int parentIndex = (int)Math.floor((i - 1)/2);

        while(i > 0 && element > heap[parentIndex]) {
            heap[i] = heap[parentIndex];
            i = parentIndex;
            parentIndex = (int)Math.floor((i - 1) / 2);
        }
        heap[i] = element;
        size++;
    }

    public void printHeap() {
        if(heap == null) {
            System.out.println("null");
        }
        int iMax = size -1, i;
        if(iMax == -1) {
            System.out.println("[]");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for(i=0; i<iMax; i++) {
            stringBuilder.append(heap[i]);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder.append(heap[i]).append(']').toString());
    }



}
