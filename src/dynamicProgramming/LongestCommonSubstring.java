package dynamicProgramming;
/*
 * Longest Common Substring 
 * 
 * Given two strings ¡®X¡¯ and ¡®Y¡¯, find the length of the longest common substring. 
 * 
 * For example, if the given strings are ¡°GeeksforGeeks¡± and ¡°GeeksQuiz¡±, the output
 *  should be 5 as longest common substring is ¡°Geeks¡±
 */
public class LongestCommonSubstring {
    
    int LCSubStr(String x, String y) {
        if (x == null || y == null)
            return 0;
        int result = 0;
        int lenX = x.length();
        int lenY = y.length();
        
        int dp[][] = new int[lenX+1][lenY+1];
        
        for (int i = 0; i <= lenX; i++) {
            for (int j = 0; j <= lenY; j++) {
                if (i ==0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1]+1;
                        result = Math.max(result, dp[i][j]);
                    } else
                        dp[i][j] = 0;
                }
            }
        }
        return result;
    }

}
