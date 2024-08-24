package com.sumeeth.googleinterview.concepts.ds.array;

import java.util.Arrays;
import java.util.List;

public class RangeRandomNumbers {

    public static void main(String[] args) {
//        List<int[]> ranges = Arrays.asList( new int[]{1,5}, new int[]{4,5},new int[]{4,9},new int[]{9,20});
        List<int[]> ranges = Arrays.asList( new int[]{1,5}, new int[]{20,29}, new int[]{1,3});

//        int max = 10;
//        int min = 1;
//        int range = max - min + 1;
//
//        // generate random numbers within 1 to 10
//        for (int i = 0; i < 10; i++) {
//            int rand = (int)(Math.random() * range) + min;
//
//            // Output is different everytime this code is executed
//            System.out.println(rand);
//        }
        System.out.println(getRandomV2(ranges));
    }

    private static int getRandomV1(List<int[]> ranges) {
        int rangeCount = ranges.size();
        int randomRange = (int)(Math.random() * rangeCount);

        int[] selectedRange = ranges.get(randomRange);
        int max = selectedRange[1];
        int min = selectedRange[0];
        int selectedRangeLength = max - min +1;

        return  (int)(Math.random() * selectedRangeLength) + min;


    }

    private static int getRandomV2(List<int[]> ranges) {
        int res=0;
        int rangeCount = 0;

        for(int[] range : ranges){
            rangeCount += range[1] - range[0] +1;
        }
        int randomRange = (int)(Math.random() * rangeCount);

        for(int[] range : ranges){
            if(randomRange <= (range[1] - range[0] +1)){
                res= (int)(Math.random() * (range[1] - range[0] +1)) + range[0];
                break;
            }else{
                randomRange -= (range[1] - range[0] +1);
            }
        }
        return  res;


    }
}
