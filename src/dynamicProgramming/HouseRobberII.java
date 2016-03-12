package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 213. House Robber II
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a 
new place for his thievery so that he will not get too much attention.
This time, all houses at this place are arranged in a circle. That means
 the first house is the neighbor of the last one. Meanwhile, the security 
system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of 
each house, determine the maximum amount of money you can rob tonight without
 alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        else if (length == 2)
            return Math.max(nums[0], nums[1]);
        
        int dp[] = new int[length];
        // first scan, includes first house, not last house
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        int profit = dp[length-1];
        // second scan, includes last house, not first house
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        
        return Math.max(profit, dp[length-1]);
    }

}
