package arrays;
/*
 * Leetcode 697. Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as 
 * the maximum frequency of any one of its elements.

    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has 
    the same degree as nums.
    
    Example 1:
    Input: [1, 2, 2, 3, 1]
    Output: 2
    Explanation: 
    The input array has a degree of 2 because both elements 1 and 2 appear twice.
    Of the subarrays that have the same degree:
    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    The shortest length is 2. So return 2.
    Example 2:
    Input: [1,2,2,3,1,4,2]
    Output: 6
    Note:
    
    nums.length will be between 1 and 50,000.
    nums[i] will be an integer between 0 and 49,999.
 */
import java.util.*;
public class DegreeOfAnArray {
    class IPos {
        int start;
        int end;
        int cnt;
    }
    public int findShortestSubArray(int[] nums) {
        if (nums ==null )
            return 0;
        if (nums.length < 2)
            return nums.length;
        HashMap<Integer,IPos > map = new HashMap<>();
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        
        
        for (int i = 0; i < nums.length;i++) {
            IPos p = map.get(nums[i]);
            if (p == null) {
                p = new IPos();
                p.cnt = 1;
                p.start = i;
                map.put(nums[i],p);
                
            } else {
                p.cnt++;

            }
            
            p.end = i;
            
            if (p.cnt > max) {
                set.clear();
                max = p.cnt;
                set.add(nums[i]);
            } else if (p.cnt == max) {
                set.add(nums[i]);
            }
        }
        int length = nums.length;
        
        for (int i:set) {
            IPos p = map.get(i);
            length = Math.min(length, p.end-p.start+1);
        }
        
        
        return length;
        
    }
    
    public static void main(String args[]) {
        int a1[] = {1,2,2,3,1};
        DegreeOfAnArray d = new DegreeOfAnArray();
        System.out.println(d.findShortestSubArray(a1));
    }

}
