package dynamicProgramming;
/*
 * LeetCode 718. Maximum Length of Repeated Subarray
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
    
    Example 1:
    Input:
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    Output: 3
    Explanation: 
    The repeated subarray with maximum length is [3, 2, 1].
    Note:
    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100
 */
public class MaxLenRepeatSubArray {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null)
            return 0;
        int m = A.length;
        int n = B.length;
        // dp[i][j] stands for longest common array in A[i-1] and B[j-1]
        int dp[][] = new int[m+1][n+1];
        int max = 0;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // initial value is 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i-1] == B[j-1]){
                    // same value
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
        
    }
}
