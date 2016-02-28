package dynamicProgramming;
/*
 * Leetcode 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you 
like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

1. You may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
2. After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        // sell[i] means max profit at day i , last transaction is sell
        int sell[] = new int[length];
        // buy[i] means max profit at day i , last transaction is buy
        int buy[] = new int [length];
        // cool[i] means max profit at day i , last transaction is cool down
        int cool[] = new int [length];
        
        sell[0] = 0;
        cool[0] = 0;
        // sell at day 0 means profit is negative number
        buy[0] = -prices[0];
        for (int i = 1; i < length; i++) {
            sell[i] = Math.max(sell[i - 1], cool[i - 1]);         
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            cool[i] = buy[i - 1] + prices[i];
            
        }
        return Math.max(sell[length-1], cool[length-1]);
        
    }

}
