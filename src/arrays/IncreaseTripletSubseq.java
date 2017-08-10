package arrays;
/*
 * Leetcode 334. Increasing Triplet Subsequence
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
 */

public class IncreaseTripletSubseq {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int min;
        int secondMin;
        
        if (nums[0] < nums[1]) {
            min = nums[0];
            secondMin = nums[1];
        } else {
            min = nums[1];
            secondMin = Integer.MAX_VALUE;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] <= min)
                min = nums[i];
            else if (nums[i] <= secondMin)
                secondMin = nums[i];
            else 
                return true;
        }
        
        return false;
        
    }
}
