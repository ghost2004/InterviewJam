package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 188. Best Time to Buy and Sell Stock IV
 * 
 * Say you have an array for which the ith element is 
 * the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may 
complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        // return 0 if no transaction
        if (k == 0)
            return 0;
        int length = prices.length;
        // k is bigger than days, that means the transaction is unlimited
        if (k >= length) {
            int max = 0;
            for (int i = 1; i < length; i++) {
                if (prices[i] > prices[i-1])
                    max += prices[i] - prices[i-1];
            }
            return max;
        }
        
        // mustSell[i][j] means in first i days with at most j transactions, 
        // and stock must be sold at day i
        int mustSell[][] = new int [length][k+1];
        // globalBest[i][j] means max profit in first i days with at most j transactions 
        int globalBest[][] = new int [length][k+1];
        
        // the profit of first day is always zero
        Arrays.fill(mustSell[0], 0);
        Arrays.fill(globalBest[0], 0);
        
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i-1];
            // the profit without transaction is zero
            mustSell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                // the max profit of day i, j transaction, and must sell at day i is 
                mustSell[i][j] = Math.max(globalBest[i-1][j-1] + Math.max(0, diff),   // the max profit last day and w/o i day transaction
                        mustSell[i-1][j]+diff);     // last day transaction plus today 
                globalBest[i][j] = Math.max(globalBest[i-1][j], mustSell[i][j] );
            }
            
        }
        
        
        return globalBest[length-1][k];
        
    }

}
