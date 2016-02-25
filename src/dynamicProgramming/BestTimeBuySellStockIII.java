package dynamicProgramming;
/*
 * Leetcode 123. Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of 
 * a given stock on day i.

Design an algorithm to find the maximum profit. You may complete 
at most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length < 2)
            return maxProfit;
        int leftProfit[] = new int[prices.length];
        int min = prices[0];
        int rightProfit = 0;
        leftProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            leftProfit[i] = Math.max(leftProfit[i], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        maxProfit = leftProfit[prices.length-1];
        int max = prices[prices.length-1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rightProfit = Math.max(rightProfit, max - prices[i]);
            max = Math.max(max,prices[i]);
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit);
            
        }
        return maxProfit;
    }

}
