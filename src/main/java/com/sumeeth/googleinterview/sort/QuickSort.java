package com.sumeeth.googleinterview.sort;

public class QuickSort {

    // Method to partition the array

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];  // Choosing the first element as the pivot
        int i = low;  // Pointer starting from the beginning
        int j = high; // Pointer starting from the end

        while (i < j) {
            // Move `i` right until an element greater than the pivot is found
            while (i < high && array[i] <= pivot) {
                i++;
            }
            // Move `j` left until an element less than or equal to the pivot is found
            while (array[j] > pivot) {
                j--;
            }
            // Swap elements at `i` and `j` if `i` is less than `j`
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Place the pivot element in the correct position
        array[low] = array[j];
        array[j] = pivot;

        return j;  // Return the index of the pivot
    }

    // The main method that implements QuickSort
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Utility method to print the array
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the QuickSort
    public static void main(String[] args) {
        int[] array = {8, 7, 6, 1, 0, 9, 2};
        System.out.println("Unsorted Array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}
