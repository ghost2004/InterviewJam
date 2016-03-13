package dynamicProgramming;
/*
 * Leetcode 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements 
 * between indices i and j (i <= j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

public class NumArray {
    int dp[];
    public NumArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            dp = new int[1];
            dp[0] = 0;
            return;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length;i++)
            dp[i] = dp[i-1] + nums[i];
        
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return dp[j];
        return dp[j] - dp[i-1];
    }
}
