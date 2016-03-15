package dynamicProgramming;
/*
 * Leetcode 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of steps required to 
 * convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j] means edit distance from word1(0,i) to word2(0,j)
        int dp[][] = new int[len1+1][len2+1];
        int i,j;
        // initialize DP matrix
        for (i = 0; i <= len1; i++) {
            // edit distance from word1(0,i) to empty string is i
            dp[i][0] = i;
        }
        
        for (j = 0; j <= len2; j++) {
            // edit distance from word2(0,j) to empty string is j
            dp[0][j] = j;
        }
        
        for (i = 0; i < len1; i++) {
            for (j = 0;j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    // same character, same edit distance
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j+1] + 1;
                    int delete = dp[i+1][j] + 1;
                    dp[i+1][j+1] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        
        return dp[len1][len2];
    }
}
