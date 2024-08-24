package com.sumeeth.googleinterview.puzzle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {
    static BigDecimal price = new BigDecimal(2);

    static class Share {
        Long qty;
        BigDecimal notional;
        String strategy;

        Share(Long qty, String strategy) {
            this.qty = qty;
            this.strategy = strategy;
            this.notional = price.multiply(BigDecimal.valueOf(this.qty));
        }
    }

    public static void main(String[] args) {
//        List<Share> shares = Arrays.asList(
//                 new Share(30L, "A")
//                , new Share(40L, "A")
//                , new Share(60L, "A")
//                , new Share(100L, "A")
//                , new Share(280L, "A")
//                , new Share(17L, "A")
//                , new Share(25L, "A")
//                , new Share(33L, "A")
//                , new Share(4L, "A")
//                , new Share(100L, "A")
//                , new Share(20L, "A")
//                , new Share(30L, "A")
//                , new Share(40L, "A")
//                , new Share(221L, "A")
////                extra shares
//                , new Share(30L, "A")
//                , new Share(21L, "A")
//
//        );
//        BigDecimal W = BigDecimal.valueOf(2000);
//        List<Share> knapsackShares = knapsack(W,shares)
        int[][] items = new int[4][2];
        items[0][0]= 1;
        items[0][1]= 2;

        items[1][0]= 4;
        items[1][1]= 3;

        items[2][0]= 5;
        items[2][1]= 6;

        items[3][0]= 6;
        items[3][1]= 7;
        knapsackProblem(items,10);
//
//        knapsackProblem(items,10);
//        int[] wt = new int[4];
//        wt[0]= 1;
//        wt[1]= 4;
//        wt[2]= 5;
//        wt[3]= 6;
//        int[] val = new int[4];
//        val[0]= 2;
//        val[1]= 3;
//        val[2]= 6;
//        val[3]= 7;
//
//        System.out.println(knapSack(10,wt,val,4));

    }

    static int knapSackRec(int W, int wt[],
                           int val[], int n,
                           int [][]dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        //it is already calculated
        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val,
                    n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W] = Math.max((val[n - 1] +
                            knapSackRec(W - wt[n - 1], wt,
                                    val, n - 1, dp)),
                    knapSackRec(W, wt, val,
                            n - 1, dp));
    }

    static int knapSack(int W, int wt[], int val[], int N)
    {

        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];

        // Loop to initially filled the
        // table with -1
        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSackRec(W, wt, val, N, dp);
    }

//    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
//        // Write your code here.
//        // Replace the code below.
//        List result = new ArrayList<List<Integer>>();
//        int n = items.length;
//        int[] dp = new int[capacity+1];
//
//        for (int i = 1; i < n +1; i++) {
//            for (int w = capacity; w >= 0; w--) {
//
//                if (items[i - 1][0] <= w)
//
//                    // finding the maximum value
//                    dp[w] = Math.max(dp[w],
//                            dp[w - items[i - 1][0]] + items[i - 1][1]);
//            }
//        }
//        System.out.println(dp[capacity]);
//        return result;
//    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int n= items.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i =1; i<=n; i++){
            int curreWeight = items[i-1][1];
            int curreValue = items[i-1][0];
            for(int w=0; w<=capacity ; w++){
                if(curreWeight > w){
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(curreValue + dp[i-1][w - curreWeight], dp[i-1][w]);
                }
            }
        }
        System.out.println(dp);
        return null;
    }

}
