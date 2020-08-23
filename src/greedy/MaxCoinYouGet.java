package greedy;

import java.util.Arrays;

/*
 * There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:

In each step, you will choose any 3 piles of coins (not necessarily consecutive).
Of your choice, Alice will pick the pile with the maximum number of coins.
You will pick the next pile with maximum number of coins.
Your friend Bob will pick the last pile.
Repeat until there are no more piles of coins.
Given an array of integers piles where piles[i] is the number of coins in the ith pile.

Return the maximum number of coins which you can have.
 */

public class MaxCoinYouGet {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int times = piles.length / 3;
        int coins = 0;
        int idx = piles.length - 2;
        for (int i = 0; i < times; i++) {
            coins += piles[idx];
            idx -= 2;
        }
       
        return coins;    
            
    }

    public static void main(String args[]) {
        int piles1[] = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles1));
    }
}
