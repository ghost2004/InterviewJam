package dynamicProgramming;
/*
 * Leetcode 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock 
 * on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each 
transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock 
share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
public class BestTimeBuySellStockV {
    
    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length < 2)
            return 0;
        // max profit without holding stock at day i
        int T_ik0 = 0;
        // max profit with holding stock at day i
        int T_ik1 = Integer.MIN_VALUE;
        
        for (int price : prices) {
            int old = T_ik0;
            // either didn't hold stock day before, or hold the stock the day before and sell it at this day
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            // either hold stock the day before, or didn't hold the stock and buy stock at this day.
            T_ik1 = Math.max(T_ik1, old - fee - price);
        }

        
        return T_ik0;
        
    }
    
    public static void main(String args[]) {
        BestTimeBuySellStockV b = new BestTimeBuySellStockV();
        int a1[] = {1, 3, 2, 8, 4, 9};
        int a2[] = {1,4,6,2,8,3,10,14};
        int a3[] = {1, 100, 100, 200};

        System.out.println(b.maxProfit(a1, 2));
        System.out.println(b.maxProfit(a2, 3));
        System.out.println(b.maxProfit(a3, 3));
    }

}
