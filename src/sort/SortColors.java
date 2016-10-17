package sort;
/*
 * Leetcode 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color
 *  are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int counters[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counters[nums[i]]++;
        }
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            while (counters[val] == 0) {
                val++;
            }
            nums[i] = val;
            counters[val]--;
        }
        
    }
}
