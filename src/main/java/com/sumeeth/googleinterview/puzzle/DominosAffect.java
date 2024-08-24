package com.sumeeth.googleinterview.puzzle;

public class DominosAffect {

    public static void main(String[] args) {
        String  dominos = ".L.R...LR..L.";
        char[] leftDominos = new char[dominos.length()];
        char[] rightDominos = new char[dominos.length()];
        char nullChar='\0';
        char prevChar=nullChar;
        char nextChar=nullChar;
        char currChar=nullChar;
//        for(int i=0; i< dominos.length();i++){
//            currChar = dominos.charAt(i);
//            if(i-1 >= 0){
//                prev = dominos.charAt(i-1);
//            }
//            if(i+1 <= dominos.length()){
//                next = dominos.charAt(i+1);
//            }
//
//            if(currChar == '.'){
//                if(prev=='R' && next =='L'){
//                    currChar='.';
//                }else if(prev=='R' && next =='L'){
//
//                }
//            }
//
//        }

        int prev=0;
        int next=0;
        int currIndex=0;
        while(currIndex < dominos.length()){
            prev = currIndex-1;
            next = currIndex+1;
            while(prev>=0 &&  dominos.charAt(prev)=='.'){
                prev--;
            }
            leftDominos[currIndex] =  dominos.charAt(prev>=0?prev:0);

            while(next < dominos.length() && dominos.charAt(next)=='.'){
                next++;
            }
            rightDominos[currIndex] =  dominos.charAt(next<dominos.length()?next:dominos.length()-1);
            currIndex++;

        }
        System.out.println(leftDominos);
        System.out.println(rightDominos);
        char[] res = new char[dominos.length()];
        for(int i=0; i<dominos.length(); i++){
            if(rightDominos[i]!='.' && leftDominos[i]!='.'){
                res[i]='.';
            }else if(rightDominos[i]!='.' && leftDominos[i]=='.'){
                res[i]=rightDominos[i];
            }else if(rightDominos[i]=='.' && leftDominos[i]!='.'){
                res[i]=leftDominos[i];
            }
        }
        String output = "LL.RR.LLRRLL..";
    }
}
