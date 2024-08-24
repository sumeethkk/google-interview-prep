package com.sumeeth.googleinterview.puzzle;

import java.util.ArrayList;
import java.util.List;


public class StringPermute {

    public static void main(String[] args) {
        String input ="abc";
//        System.out.println(permute(input,0,input.length()-1,new ArrayList<>()));
       permute(input,0,input.length()-1,new ArrayList<>()).stream().forEach(System.out::println);
    }

    private static List<String> permute(String inputStr, int l, int r, List<String> res) {


        if (l == r)
            res.add(inputStr);
        else {
            for (int i = l; i <= r; i++) {
                inputStr = swap(inputStr, l, i);
                permute(inputStr, l + 1, r, res);
                inputStr = swap(inputStr, l, i);
            }
        }
        return res;
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
