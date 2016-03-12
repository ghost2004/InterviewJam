package dynamicProgramming;
/*
 * Leetcode 312. Burst Balloons
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it
 *  represented by array nums. You are asked to burst all the balloons. If the you burst 
 *  balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right
 *   are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ¡Ü n ¡Ü 500, 0 ¡Ü nums[i] ¡Ü 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBallons {

    public int maxCoins(int[] nums) {
        int length = nums.length;
        int array[] = new int[length+2];
        array[0] = 1;
        for (int i = 0; i < length; i++) {
            array[i+1] = nums[i];
        }
        array[length+1] = 1;
        int dp[][] = new int[length+2][length+2];
        
        for (int len = 1; len <= length; len++ ) {
            for (int left = 1; left <= length-len+1; left++) {
                int right = left+len-1;
                for (int idx = left; idx <= right; idx++) {
                    dp[left][right] = Math.max(dp[left][right] , dp[left][idx-1]+array[left-1]*array[idx]*array[right+1]+dp[idx+1][right]);
                }
                
            }
        }
        
        return dp[1][length];
        
    }
    
    public static void main(String args[]) {
        BurstBallons b = new BurstBallons();
        int input1[] = {3, 1, 5, 8};
        System.out.println(b.maxCoins(input1));
    }

}
