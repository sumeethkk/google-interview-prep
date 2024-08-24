package com.sumeeth.googleinterview.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.Function;


public class CustomSort implements Sort {
    static Logger logger = LoggerFactory.getLogger(CustomSort.class);

    private Integer[] unsortedArray;

    private Function<Integer[], Integer[]> sort;

    public CustomSort(Integer[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public CustomSort(Integer[] unsortedArray, Function<Integer[], Integer[]> sort) {
        this.unsortedArray = unsortedArray;
        this.sort = sort;
    }

    public CustomSort(Function<Integer[], Integer[]> sort) {
        this.sort = sort;
    }

    public void displayArray() {
        System.out.println(Arrays.asList(unsortedArray));
    }

    public static void main(String[] args) {
//        CustomSort sort = new CustomSort(new Integer[]{1, 2, 4, 1, 6, 4, 9});
//        sort.displayArray();
//        sort.bubbleSort();
//        sort.insertionSorting();
//        sort.selectionSorting();
//        sort.displayArray();

        Sort mergeSort = new CustomSort(MergeSort::sort);
        mergeSort.sort(new Integer[]{9,8,7,6,5,4,3,2,1});


    }

    public void bubbleSort() {
        boolean isSorted = false;
        int lastIndex = unsortedArray.length - 1;
        while (!isSorted && lastIndex > 0) {
            System.out.println("Outer iteration: " + lastIndex);
            isSorted = true;
            lastIndex--;
            for (int i = 0; i < lastIndex; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    swap(i, i + 1);
                    isSorted = false;
                }

            }

        }

    }

    //insert element from unsorted array to sorted array
    //1,2,4,1,6,4,9
    public void insertionSorting() {
        int endIndex = 1;
        while (endIndex <= unsortedArray.length - 1) {
            for (int i = endIndex; i > 0; i--) {
                if (unsortedArray[i] < unsortedArray[i - 1]) {
                    swap(i, i - 1);
                } else break;
            }
            endIndex++;
        }

    }

    //select min element, then swap it with other min element if available while iterating the array
    //4,3,2,1
    public void selectionSorting() {
        int smallestIndex = 0;
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            smallestIndex = i;
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[smallestIndex] > unsortedArray[j]) {
                    smallestIndex = j;
                }
            }
            swap(smallestIndex, i);
        }


    }

    private void swap(int i, int j) {
        System.out.println("Swapping : " + unsortedArray[i] + " &" + unsortedArray[j]);
        int tmp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[j];
        unsortedArray[j] = tmp;
    }

    @Override
    public Integer[] sort(Integer[] unsortedArray) {
        if (unsortedArray == null) {
            throw new IllegalStateException("Input array can't be null");
        }
        if (sort == null) {
            logger.info("No sorting method supplied. Applying default sorting method");
            insertionSorting();
            return unsortedArray;
        } else {
            logger.info("Using custom sort method...");
            return sort.apply(unsortedArray);
        }
    }
}
