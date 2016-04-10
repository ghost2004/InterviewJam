package arrays;
/*
 * Leetcode 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while
 *  maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int wrtIdx = -1;
        int zeroCnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (wrtIdx == -1)
                    wrtIdx = i;
                zeroCnt++;
            } else {
                if (wrtIdx != -1)
                    nums[wrtIdx++] = nums[i];
            }
        }
        
        for (int i = nums.length - zeroCnt; i < nums.length; i++)
            nums[i] = 0;
    }

}
