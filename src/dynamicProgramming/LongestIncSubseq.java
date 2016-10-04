package dynamicProgramming;
/*
 * Leetcode 300. Longest Increasing Subsequence
 *  Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that 
there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
import java.util.*;
public class LongestIncSubseq {
    /* solution of O(n^2) */
    public int lengthOfLIS_v2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        // dp[i] means longest increasing subsequence at i
        int dp[] = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            // at least it is 1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    // less than the end of sub-array
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            // update max value
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    

    /* solution of O(nlogn) Binary search*/
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
               
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < len;i++) {
            // add current number to the list
            // 1. the list is empty
            // 2. larger than biggest number in the list
            if(list.isEmpty() || list.get(list.size()-1) < nums[i]) {
                list.add(nums[i]);
            } else {
                // the current number is less than biggest number in the list
                // do binary search to get the insert position
                // replace the element in the list which is the smallest but bigger than num
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int mid = (right+left)/2;
                    if (list.get(mid) < nums[i]) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                list.set(left, nums[i]);
            }
        }
        
        return list.size();
    }
}
