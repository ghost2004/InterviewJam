package dynamicProgramming;

/*
 * Leetcode 115. Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        // DP[i][j] means the number of subsequences for t(0,j) in s(0,i)
        int dp[][] = new int [sLen+1][tLen+1];
        // initialized state is alway 1
        for (int i = 0; i <= sLen; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        
        return dp[sLen][tLen];
    }

}
