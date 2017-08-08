package arrays;
/*
 * 
 * Leetcode 442. Find All Duplicates in an Array
 * Given an array of integers, 1 <= a[i] <= n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
import java.util.*;
public class DuplicatesInArray {
    
    public List<Integer> findDuplicates_Set(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i:nums) {
            if (set.contains(i))
                out.add(i);
            else
                set.add(i);
        }
        return out;
        
    }
    
    public List<Integer> findDuplicates_Sort(int[] nums) {
        Arrays.sort(nums);
        List<Integer> out = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i] == nums[i+1]) {
                out.add(nums[i]);
                while ( i <nums.length -1 && nums[i] == nums[i+1])
                    i++;
            }
        }
        return out;
    }
    

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                out.add(index+1);
            nums[index] = -nums[index];
        }
        return out;
    }
}
