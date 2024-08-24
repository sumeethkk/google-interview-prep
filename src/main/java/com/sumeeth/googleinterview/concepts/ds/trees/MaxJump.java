package com.sumeeth.googleinterview.concepts.ds.trees;

import java.util.HashMap;
import java.util.Map;

class MaxJump {
    public static void main(String[] args) {
        int[] arr = new int[]{ 3,2,1,0,4};
        System.out.println(canJump(arr));
        System.out.println("ggyllaylacrhdzedddjsc".charAt(firstNonRepeatingCharacter("ggyllaylacrhdzedddjsc")));
    }

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> charFreq= new HashMap<>();
        int i = 0;
        while(i<string.length()){
                Character ch = string.charAt(i);
                charFreq.put(ch,charFreq.getOrDefault(ch,0)+1);
            i++;
        }
        i = 0;
        while(i<string.length()){
            Character ch = string.charAt(i);
            if(charFreq.get(ch)==1){
                return i;
            }
            i++;
        }
        return -1;

    }
    public static boolean canJump(int[] nums) {
        int currPositon = 0;
        int jump = nums[currPositon];

        while (currPositon < nums.length && jump != 0) {
            currPositon = currPositon + jump;
            if (currPositon > nums.length) {
                return false;
            } else if (nums[currPositon] == nums[nums.length - 1]) {
                return true;
            } else {
                jump = nums[currPositon];
            }
        }
        return false;
    }
}
