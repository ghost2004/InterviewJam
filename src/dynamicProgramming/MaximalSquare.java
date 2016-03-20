package dynamicProgramming;
/*
 * leetcode 221. Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing 
 * all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int i,j;
        int dp[][]  = new int[m][n];
        
        for (i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] =1;
                max = 1;
            }
        }

        for (i = 1; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }

        for (i = 1; i < m ; i++) {
            for (j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = min+1;
                    max = Math.max(max, dp[i][j]);
                }
                
            }
        }
        
        return max*max;
        
    }

}
