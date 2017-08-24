package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 416. Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers, find if the array can be partitioned 
 * into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 */
public class PartitionEqualSubset {
    
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        int total = 0;
        
        // get the sum of the array
        for (int s:nums) 
            total += s;
        // no possible solution for odd numbers
        if (total % 2 != 0)
            return false;
        
        // we are looking for a non-empty subset with sum as half of total
        int target = total/2;

        // dp[i] stands for if there is subset in array with sum as i
        boolean dp[] = new boolean[target];
        // by default set to false, and dp[0] is true
        Arrays.fill(dp, false);
        dp[0] = true;
        
        // scan every elements in the array
        for (int i = 0; i < nums.length; i++) {
            // if target minus this number is true, we found the solution
            if (nums[i] <= target && dp[target-nums[i]])
                return true;
            // in case we selected this number, set all possible bit
            for (int j = target-1; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
            
        }
             
        return false;
    }

}
