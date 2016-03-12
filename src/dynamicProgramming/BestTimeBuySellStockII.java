package dynamicProgramming;
/*
 * Leetcode 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you
 like (ie, buy one and sell one share of the stock multiple times). However, you may not 
 engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length < 2)
            return max;
        
        for (int i = 1; i < prices.length; i++) {
            int gain = prices[i] - prices[i-1];
            if (gain > 0)
                max += gain;
        }
        
        return max;
    }

}
