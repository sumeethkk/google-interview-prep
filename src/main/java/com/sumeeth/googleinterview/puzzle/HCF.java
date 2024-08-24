package com.sumeeth.googleinterview.puzzle;

public class HCF {
    public static void main(String[] args) {
        int a=70,b=15;
        System.out.println("HCF of "+a+" & "+b+" is: "+findHCF(a , b));
    }

    private static int findHCF(int a, int b) {
        if( a > 0  & b > 0){
            if(a % b ==0){
                return b;
            }
            else if(b % a == 0){
                return a;
            }else {
                int firstNum=0;
                int secNum=0;
                if(a > b){
                    firstNum =b;
                    secNum=a;
                }else {
                    firstNum=a;
                    secNum=b;
                }
                int hcf=1;
                for(int i=1; i<secNum ; i++){
                    if(firstNum%i==0 && secNum%i==0){
                        hcf=i;
                    }
                }

                return hcf;
            }
        }
        return -1;
    }
}
