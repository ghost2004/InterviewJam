package dynamicProgramming;
/*
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
        int dp[][] = new int[len1+1][len2+1];
        int i,j;
        for (i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        
        for (j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        
        for (i = 0; i < len1; i++) {
            char s1 = word1.charAt(i);
            for (j = 0;j < len2; j++) {
                
            }
        }
        
        return dp[len1][len2];
    }
}
