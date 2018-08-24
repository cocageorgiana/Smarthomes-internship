package com.example.smarthomes.parallelprocessingsorting.sorting;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SortingAlgorithms {

    public String bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }

            }
        }
        return Arrays.toString(arr);
    }


    public String insertionSort(int arr[]) {

        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return Arrays.toString(arr);
    }


    private static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = 0;

        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {

                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    public String quickSort(int arr[], int low, int high) {
        if(0 < arr.length - 1) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot+1, high);
        }
        return Arrays.toString(arr);
    }


    public String selectionSort(int arr[]) {

        for(int i = 0; i<arr.length - 1; i++) {

            int minIndex = i;

            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int aux = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = aux;
        }
        return Arrays.toString(arr);
    }


    void merge(int arr[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int tempLeft[] = new int[n1];
        int tempRight[] = new int[n2];

        for(int i=0; i<n1; i++) {
            tempLeft[i] = arr[left + i];
        }
        for(int j=0; j<n2; j++) {
            tempRight[j] = arr[middle + 1 + j];
        }

        int i=0, j=0;
        int k=1;

        while(i<n1 && j<n2) {
            if(tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            }
            else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }
        while(i<n1) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }
        while(j<n2) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }



    public void mergeSort(int arr[], int left, int right) {
        if(left < right) {
            int middle = (left+right)/2;

            mergeSort(arr , left, middle);
            mergeSort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }

        for(int i : arr) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    public void heapify(int arr[], int n, int i) {

        int largest = i;
        int leftNode = 2*i + 1;
        int rightNode = 2*i + 2;

        if(leftNode < rightNode && arr[leftNode] > arr[largest]) {
            largest = leftNode;
        }

        if(rightNode < n && arr[rightNode] > arr[largest]) {
            largest = rightNode;
        }

        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
        }
        heapify(arr, n, largest);
    }

    public String heapSort(int arr[]) {

        for(int i=arr.length/2-1; i>=0; i--) {
            heapify(arr, arr.length, i);
        }

        for(int i=arr.length-1; i>=0; i--) {
            int aux = arr[0];
            arr[0] = arr[i];
            arr[i] = aux;

            heapify(arr, i, 0);
        }
        return Arrays.toString(arr);
    }
}

