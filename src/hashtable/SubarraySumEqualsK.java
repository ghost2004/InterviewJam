package hashtable;

/*
 * Leetcode 560. Subarray Sum Equals K
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
import java.util.*;
public class SubarraySumEqualsK {
    
    // Brute force solution 
    // Time complexity O(n^2), Space complexity O(1).
    public int subarraySumBruteforce(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int total = 0;
            for (int j = i; j < len; j++) {
                total += nums[j];
                if (total == k)
                    count++;
            }
        }
        return count;
    }
    
    // DP solution with HashMap
    // From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
    // To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. 
    // Time complexity O(n), Space complexity O(n).
    public int subarraySum(int[] nums, int k) {
    
        int result = 0;
        int sum = 0;
        // the map from sum to count
        Map<Integer, Integer> preSum = new HashMap<>();
        // by default there is one empty sub-array with sum 0, so put 0 -> 1 
        preSum.put(0, 1);
        for (int i : nums) {
            sum += i;
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
    

}
