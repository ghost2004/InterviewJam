package dynamicProgramming;
/*
 * Leetcode 673. Number of Longest Increasing Subsequence
 * 
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 
subsequences' length is 1, so output 5.
 */
public class NumOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int len = nums.length;

        // dp[i] means longest increasing subsequence at i
        int dp[] = new int[len];
        // cnt[i] means the number of longest increasing subsequence at i
        int cnt[] = new int[len];
        int max_len = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            // at least it is 1
            dp[i] = 1;
            cnt[i] = 1;
            
            for (int j = 0; j < i; j++) { 
                // pass it if it can't make increasing subsequence
                if (nums[j] >= nums[i])
                    continue;
                if (dp[i] == dp[j] + 1) 
                    cnt[i] += cnt[j];
                else if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }
                
            }
            // more path for current  max length subsequence
            if (dp[i] == max_len) 
                res += cnt[i];
            // found new max length subsequence
            if (dp[i] > max_len) {
                max_len = dp[i];
                res = cnt[i];
            }

        }
        return res;
    }
    
    public static void main(String args[]) {
        NumOfLIS n = new NumOfLIS();
        int a1[] = {1,3,5,4,7};
        int a2[] = {2,2,2,2,2};
        int a3[] = {1,2,4,3,5,4,7,2};
        int a4[] = {3,1,2};
        System.out.println(n.findNumberOfLIS(a1));
        System.out.println(n.findNumberOfLIS(a2));
        System.out.println(n.findNumberOfLIS(a3));
        System.out.println(n.findNumberOfLIS(a4));
    }
}
