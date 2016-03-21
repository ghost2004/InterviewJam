package dynamicProgramming;
/*
 * Leetcode 152. Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number)
 *  which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret, curMin, curMax;
        ret = curMin = curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = curMax;
            curMax = Math.max(curMax*nums[i], Math.max(nums[i], nums[i]*curMin));
            curMin = Math.min(curMin*nums[i], Math.min(nums[i], tmp*nums[i]));
            ret = Math.max(curMax, ret);
        }
        
        return ret;
        
    }

}
