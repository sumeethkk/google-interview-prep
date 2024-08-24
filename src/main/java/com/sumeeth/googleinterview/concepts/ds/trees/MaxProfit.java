package com.sumeeth.googleinterview.concepts.ds.trees;

public class MaxProfit {
        public int maxProfit(int[] prices) {

            int currentProfit = 0; //max value
            int maxProfit = 0;
            String nextAction= "sell";
            int currentPrice = 0;
            int nextPriceIndex = 0;
            int futurePriceIndex = 0;
            for(int i=0; i<prices.length; i++){
                currentPrice = prices[i];
                nextPriceIndex = i+1;
                futurePriceIndex = nextPriceIndex+1;
                while(nextPriceIndex < prices.length && futurePriceIndex < prices.length){
                    if(nextAction == "sell"){
                        if(prices[futurePriceIndex] >= prices[nextPriceIndex]){
                            futurePriceIndex++;
                        }else if(prices[futurePriceIndex] < prices[nextPriceIndex]  || futurePriceIndex==(prices.length-1)){
                            currentProfit = prices[nextPriceIndex] - currentPrice;
                            currentPrice = prices[nextPriceIndex];
                            nextAction= "buy";
                            nextPriceIndex++;
                            futurePriceIndex++;

                        }
                    }else{
                        if(prices[nextPriceIndex] < currentPrice){
                            currentPrice = prices[nextPriceIndex];
                        }else{
                            nextPriceIndex++;
                            futurePriceIndex++;
                        }

                    }
                }
                if(currentProfit > maxProfit){
                    maxProfit=currentProfit;
                }


            }

            return maxProfit;
        }
}
