package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 322. Coin Change
 * You are given coins of different denominations and a total amount of
 *  money amount. Write a function to compute the fewest number of coins 
 *  that you need to make up that amount. If that amount of money cannot 
 *  be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;
        
        int dp[] = new int[amount+1];
        // just make sure the default value plus 1 won't be negative number
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin:coins) {
                // add check in case of coin value overflow
                if (i+coin <= amount && i+coin >= coin) {
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE-1? -1: dp[amount];
    }

}
