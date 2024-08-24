package com.sumeeth.googleinterview.puzzle;

/**
 * Given a binary string, that is it contains only 0s and 1s.
 * We need to make this string a sequence of alternate characters by flipping some of the bits,
 * our goal is to minimize the number of bits to be flipped.
 *
 * Examples :
 *
 * Input : str = “001”
 * Output : 1
 * Minimum number of flips required = 1
 * We can flip 1st bit from 0 to 1
 *
 * Input : str = “0001010111”
 * Output : 2
 * Minimum number of flips required = 2
 * We can flip 2nd bit from 0 to 1 and 9th
 * bit from 1 to 0 to make alternate
 * string “0101010101”.
 */
public class MinimumFlip {

    public static void main(String[] args) {
        System.out.println(minimumFlip("111111"));
    }

    private static int minimumFlip(String binaryString) {
       return Math.min(filpWhenStartingChar(binaryString,'0'),filpWhenStartingChar(binaryString,'1'));
    }

    private static char flip(char ch){
        return ch=='1'?'0':'1';
    }

    private static int filpWhenStartingChar(String binaryString, char expectedChar) {
        int flipCount=0;

        for(char ch : binaryString.toCharArray()){
                if(expectedChar != ch){
                    flipCount++;
                }
                expectedChar = flip(expectedChar);
        }

        return flipCount;
    }
}
