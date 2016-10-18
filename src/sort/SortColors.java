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
    // count and re-fill solution, 2 passes needed
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
    
    // 2 pointer solution, one pass needed
    /*
    private void swap(int[] arr, int a, int b) {
        if (a != b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
    */
    public void sortColors2(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        
        int idx = 0;
        while (idx <= blueIdx) {
            if (nums[idx] == 0) {
                //swap(nums, idx, redIdx);
                nums[idx] = nums[redIdx];
                nums[redIdx] = 0;
                idx++;
                redIdx++;
                
            } else if (nums[idx] == 2) {
                //swap(nums, idx, blueIdx);
                nums[idx] = nums[blueIdx];
                nums[blueIdx] = 2;
                blueIdx--;
            } else {
                idx++;
            }
        }
        
    }
}
