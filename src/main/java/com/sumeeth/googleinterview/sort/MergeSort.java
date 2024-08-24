package com.sumeeth.googleinterview.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Divide and conquer
 */
public class MergeSort {
    static Logger logger = LoggerFactory.getLogger(MergeSort.class);

    public static Integer[] sort(Integer[] unsortedArray) {
        logger.info("Starting merge sort.");
        sort(unsortedArray, 0, unsortedArray.length - 1);
        return unsortedArray;
    }

    private static void sort(Integer[] unsortedArray, int left, int right) {
        if (left == right) return;
            Integer mid = (left + right) / 2;
            logger.info("Partitioning Left side of unsorted array left:{}, mid:{}, right:{}",left,mid, right);
            sort(unsortedArray, left, mid);

            logger.info("Partitioning Right side of unsorted array left:{}, mid:{}, right:{}",left,mid+1, right);
            sort(unsortedArray, mid + 1, right);
            logger.info("Partitioning completed");

            logger.info("Starting Merge ");

            merge(unsortedArray,left, mid, right);
            logger.info("Sorted array {}", Arrays.toString(unsortedArray));

    }

    private static void merge(Integer[] unsortedArray, int left, Integer mid, int right) {
        int leftSize = mid - left +1;
        int rightSize = right - mid;

        Integer[] L1 = new Integer[leftSize];
        Integer[] R1 = new Integer[rightSize];

        for(int i =0 ; i< leftSize; i++){
            L1[i] = unsortedArray[left+i];
        }
        for(int i =0 ; i< rightSize; i++){
            R1[i] = unsortedArray[mid+1+i];
        }


        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (L1[i] <= R1[j]) {
                unsortedArray[k] = L1[i];
                i++;
            }
            else {
                unsortedArray[k] = R1[j];
                j++;
            }
            k++;
        }


        /* Copy remaining elements of L[] if any */
        while (i < leftSize) {
            unsortedArray[k] = L1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightSize) {
            unsortedArray[k] = R1[j];
            j++;
            k++;
        }


    }


}
