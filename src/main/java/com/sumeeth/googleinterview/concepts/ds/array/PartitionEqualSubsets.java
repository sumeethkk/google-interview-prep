package com.sumeeth.googleinterview.concepts.ds.array;

import java.util.Arrays;

//can an array be partitioned into two subsets such that sum of the elements of two subsets is equal.
public class PartitionEqualSubsets {

    public static void main(String[] args) {
//        int[] input = new int[]{1,5,11,5};
        //expected output true as it can be partitioned into two subsets [1,5,5] [5]
//        int[] input = new int[]{8,6,13,10,11};
        int[] input = new int[]{1,5,11,56};

        System.out.println(canArrayBePartitioned(input));

    }

    private static boolean canArrayBePartitioned(int[] input) {
        Arrays.sort(input);
        int lastIndex = input.length -1;
        int startIndex =0;

        int leftSum=input[startIndex];
        int rightSum=input[lastIndex];
        lastIndex--;
        startIndex++;
        while (startIndex<=lastIndex){
            if(leftSum < rightSum){
                leftSum+= input[startIndex];
                startIndex++;
            }else{
                rightSum+= input[lastIndex];
                lastIndex--;
            }
            if(leftSum == rightSum && startIndex+1>=lastIndex){
                return true;
            }
        }
        return false;
    }
}
