package com.sumeeth.googleinterview.puzzle;

import com.sumeeth.googleinterview.concepts.ds.heap.MinHeapExample;

import java.util.*;

/**
 *  timeInterVal=
 * [
 *   [0, 2],
 *   [1, 4],
 *   [4, 6],
 *   [0, 4],
 *   [7, 8],
 *   [9, 11],
 *   [3, 10],
 * ]
 *
 * Find min number of laptop required for students if the usage time is provided.
 */
public class LaptopRental {

    public static void main(String[] args) {
//        List<List<Integer>> times= Arrays.asList(   //required 3
//                                          Arrays.asList(0,2),
//                                          Arrays.asList(1,4),
//                                          Arrays.asList(4,6),
//                                          Arrays.asList(0,4),
//                                          Arrays.asList(7,8),
//                                          Arrays.asList(9,11),
//                                          Arrays.asList(3,10)
//        );

//        List<List<Integer>> times= Arrays.asList( //required 4
//                Arrays.asList(0,4),
//                Arrays.asList(2,3),
//                Arrays.asList(2,3),
//                Arrays.asList(2,3)
//        );

        List<List<Integer>> times= Arrays.asList( //required 1
                Arrays.asList(1,5),
                Arrays.asList(5,6),
                Arrays.asList(6,7),
                Arrays.asList(7,9)
        );



        System.out.println("Student usage time: "+times);
        System.out.println("Min number of laptops required is "+ findMinLaptop(times));


    }

    public static int findMinLaptop(List<List<Integer>> times){
        Collections.sort(times, Comparator.comparingInt(a -> a.get(0)));
        MinHeapExample minHeap = new MinHeapExample();
        minHeap.addElement(times.get(0).get(1)); //enter end time of first element
        int laptop =1;
        for(int i=1; i< times.size(); i++){
            int startTime = times.get(i).get(0);
            int endTime = times.get(i).get(1);
            if(startTime < minHeap.getMin()){
                laptop++;
                minHeap.addElement(endTime);
            }else{
                minHeap.addElement(endTime);
                minHeap.remove();
            }

        }
        return laptop;
    }


}
