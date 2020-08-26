package arrays;
/*
 * Leetcode 491. Increasing Subsequences
 * 
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an
 *  increasing subsequence should be at least 2.

 

Example:

Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 

Constraints:

The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
import java.util.*;
public class IncreasingSubseqence {
    private Set<List<Integer>> result;
    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new HashSet<>();
        findSeqence(new ArrayList<>(), nums, 0);
        return new ArrayList<>(result);
        
    }
    
    private void findSeqence(List<Integer> cur, int nums[], int idx) {
        if (cur.size() >= 2) {
            result.add(new ArrayList<>(cur));
        }
        
        for (int i = idx; i < nums.length; i++) {
            if (cur.isEmpty() || cur.get(cur.size() - 1) <= nums[i]) {
                cur.add(nums[i]);
                findSeqence(cur, nums, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
        
    }

}
