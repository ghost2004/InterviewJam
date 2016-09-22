package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 307. Range Sum Query - Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    public static class NumArray {
        int num[];
        int sums[];

        public NumArray(int[] nums) {
            if (nums == null || nums.length < 1) {
                sums = null;
                return;
            }

            num = Arrays.copyOf(nums, nums.length);
            sums = new int[nums.length+1];
            sums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }
        }

        void update(int i, int val) {
            if (sums == null)
                return;
            int delta = val - num[i];
            if (delta == 0)
                return;
            num[i] = val;
            for (int idx = i+1; idx < sums.length; idx++)
                sums[idx] += delta;
        }

        public int sumRange(int i, int j) {
            if (sums == null)
                return 0;
            return sums[j+1] - sums[i];
        }
    }
    
    public static void  main(String args[]) {
        int test[] = {1, 3, 5};
        NumArray n = new RangeSumQueryMutable.NumArray(test);
        System.out.println(n.sumRange(0, 2));
        n.update(1, 2);
        System.out.println(n.sumRange(0, 2));
    }

}
