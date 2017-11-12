package arrays;
/*
 * LeetCode 724. Find Pivot Index
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is 

equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return 
the left-most pivot index.
    
    Example 1:
    Input: 
    nums = [1, 7, 3, 6, 5, 6]
    Output: 3
    Explanation: 
    The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
    Also, 3 is the first index where this occurs.
    Example 2:
    Input: 
    nums = [1, 2, 3]
    Output: -1
    Explanation: 
    There is no index that satisfies the conditions in the problem statement.
    Note:
    
    The length of nums will be in the range [0, 10000].
    Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {
    
    public int pivotIndex(int[] nums) {
        
        
        if (nums == null || nums.length < 2)
            return -1;
        int len = nums.length;
        int left[] = new int[len];
        int right[] = new int[len];
        
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] + nums[i-1];
        }
        
        for (int i = len-2; i >= 0; i--) {
            right[i] = right[i+1] + nums[i+1];
        }
        
        for (int i = 0; i < len; i++) { 
            if (left[i] == right[i])
                return i;
        }
        
        
        return -1;
    }
    
    public static void main(String args[]) {
        FindPivotIndex f = new FindPivotIndex();
        int a1[] = { 1, 7, 3, 6, 5, 6 };
        int a2[] = {1,2,3};
        System.out.println(f.pivotIndex(a1));
        System.out.println(f.pivotIndex(a2));
        
    }

}
