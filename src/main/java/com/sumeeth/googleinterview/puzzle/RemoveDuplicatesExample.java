package com.sumeeth.googleinterview.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesExample {

    //    two list
//    Arr1. [1,2,3,4,5]
//
//    Arr2. [3,4,6,9,10]
//
//    out [1,2,3,4,5,6,9,10]
    public static void main(String[] args) {
        int[] arr = mergeWithoutDuplicates(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 6, 9, 10});
        System.out.println(Arrays.toString(arr));

    }

    public static int[] mergeWithoutDuplicates(int p[], int q[]) {

        Map<Integer, Integer> trackDuplicates = new HashMap();
        int[] result = new int[p.length * 2];
        int resIndex = 0;
        for (int i = 0; i < p.length; i++) {

            if (!trackDuplicates.containsKey(p[i])) {
                //storing
                result[resIndex++] = p[i];

                int occurence = trackDuplicates.getOrDefault(p[i], 0);
                trackDuplicates.put(p[i], ++occurence);
            }

            if (!trackDuplicates.containsKey(q[i])) {
                //storing
                result[resIndex++] = q[i];

                int occurence = trackDuplicates.getOrDefault(q[i], 0);
                trackDuplicates.put(q[i], ++occurence);
            }


        }

        return result;

    }
}
