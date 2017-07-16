package arrays;
/*
 * Leetcode 643. Maximum Average Subarray I
 * 
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaxAverageArrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        double avg = 0;
        long total = 0;
        int idx = 0;
        
        while (idx < k) {
            total += nums[idx];
            idx++;
        }
        
        avg = 1.0*total/k;
        
        while (idx < nums.length) {
            total += nums[idx] - nums[idx-k];
            idx++;
            avg  = Math.max(avg, 1.0*total/k);
        }
        
        return avg;
    }

}
