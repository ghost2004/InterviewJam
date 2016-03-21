package dynamicProgramming;
/*
 * Leetcode 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path
 *  from top left to bottom right which minimizes the sum of all 
 *  numbers along its path.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            dp[i] = dp[i-1] + grid[0][i];
        
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        
        return dp[n-1];
    }
    
    public static void main(String args[]) {
        int a[][] = {{1}};
        MinPathSum m = new MinPathSum();
        System.out.println(m.minPathSum(a));
    }

}
