package arrays;
/*
 * Leetcode 659. Split Array into Consecutive Subsequences
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them 
 * into several subsequences, where each subsequences consist of at least 3 consecutive integers. 
 * 
 * Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]
 */
import java.util.*;
public class SplitConsecutiveArray {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        // the map of unused numbers
        HashMap<Integer, Integer> unused = new HashMap<>();
        // the map of current consecutive subsequences
        HashMap<Integer, Integer> curList = new HashMap<>();
        
        // count the frequency of each numbers
        for (int i = 0; i < nums.length; i++) {
            int cnt = unused.getOrDefault(nums[i], 0);
            cnt++;
            unused.put(nums[i], cnt);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int available = unused.get(nums[i]);
            // all of this number are used, skip
            if (available == 0)
                continue;
            
            // check if it is fit in current subsequences
            int cnt = curList.getOrDefault(nums[i], 0);
            if (cnt == 0) {
                // not fit, let's build a new one, get the next 2 numbers
                int next1 = unused.getOrDefault(nums[i]+1, 0);
                int next2 = unused.getOrDefault(nums[i]+2, 0);
                // return false if can't build it
                if (next1 == 0 || next2 == 0)
                    return false;
                // so i+3 will fit in later
                curList.put(nums[i]+3, curList.getOrDefault(nums[i]+3, 0)+1);
                // deduct the i+1 and i+2
                unused.put(nums[i]+1, next1-1);
                unused.put(nums[i]+2, next2-1);
            } else {
                // fit, deduct the current number
                curList.put(nums[i], cnt-1);
                // i+1 will be next number fit in
                curList.put(nums[i]+1, curList.getOrDefault(nums[i]+1, 0)+1);
            }
            // remove the used number
            unused.put(nums[i], available-1);
        }
        
        return true;
    }
}
