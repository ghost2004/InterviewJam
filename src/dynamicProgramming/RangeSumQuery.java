package dynamicProgramming;
/*
 * Leetcode 303. Range Sum Query - Immutable
 *Given an integer array nums, find the sum of the elements between 
 *indices i and j (i ¡Ü j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQuery {
	public class NumArray {
		int[] sums;

	    public NumArray(int[] nums) {
	    	if (nums.length < 1) {
	    		sums = null;
	    		return;
	    	}
	        sums = new int[nums.length];
	        sums[0] = nums[0];
	        for (int i = 1; i < nums.length; i++) {
	        	sums[i] = sums[i-1] + nums[i];
	        }
	    }

	    public int sumRange(int i, int j) {
	    	if (sums == null)
	    		return 0;
	        if (i == 0)
	        	return sums[j];
	        return sums[j] - sums[i-1];
	    }
	}

}
