package dynamicProgramming;

import java.util.Arrays;

/*
 * 
 * Leetcode 63. Unique Paths II
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathII {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int paths[] = new int[n];

        Arrays.fill(paths, 0);
        
        paths[0] = 1;
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)  
                    paths[0] = 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    paths[j] = 0;
                else
                    paths[j] += paths[j-1];
            }
        }
        
        return paths[n-1];
    }

}
