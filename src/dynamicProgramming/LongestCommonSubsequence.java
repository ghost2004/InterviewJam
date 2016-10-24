package dynamicProgramming;
/*
 * Longest Common Subsequence (LCS) problem 
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 *  A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 *   For example, ¡°abc¡±, ¡°abg¡±, ¡°bdf¡±, ¡°aeg¡±, ¡®¡±acefg¡±, .. etc are subsequences of ¡°abcdefg¡±. 
 *   So a string of length n has 2^n different possible subsequences.
 */
public class LongestCommonSubsequence {
    public int lcs(String x, String y) {
        if (x == null || y == null)
            return 0;
        int lenX = x.length();
        int lenY = y.length();
        int dp[][] = new int[lenX+1][lenY+1];
        for (int i = 0; i <= lenX; i++) {
            for (int j = 0; j <= lenY; j++ ) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[lenX][lenY];
    }

}
