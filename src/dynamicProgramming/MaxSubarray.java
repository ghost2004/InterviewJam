package dynamicProgramming;
/*
 * Leetcode 53 Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number)
 *  which has the largest sum.
 */
public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        int max = nums[0];
        int curMax = max;
        for (int i = 1; i < nums.length; i++) {
            
            if (curMax < 0)
                curMax = nums[i];
            else 
                curMax += nums[i];
            max = Math.max(curMax, max);
        }
        return max;
    }

}
