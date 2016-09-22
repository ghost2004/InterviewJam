package dynamicProgramming;
/*
 * Leetcode 304. Range Sum Query 2D - Immutable
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by 
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 <= row2 and col1 <= col2.
 */
public class RangeSumQuery2D {

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.sumRegion(1, 2, 3, 4);
	
	public class NumMatrix {
		int sums[][];
		
	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
	        	sums = null;
	        	return;
	        }
	        int x = matrix.length;
	        int y = matrix[0].length;
	        int i,j;
	        sums = new int[x+1][y+1];
	        for (i = 0; i <= y; i++)
	        	sums[0][i] = 0;
	        for (i = 1; i <= x; i++)
	        	sums[i][0] = 0;
	        for (i = 1; i <= x; i++) {
	        	int rowsum = 0;
	        	for (j = 1; j <= y; j++) {
	        		rowsum += matrix[i-1][j-1];
	        		sums[i][j] = sums[i-1][j] + rowsum;
	        	}
	        }
	        
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	    	if (sums == null)
	    		return 0;
	    	
	        return sums[row2+1][col2+1] + sums[row1][col1] - sums[row1][col2+1] - sums[row2+1][col1];
	    }
	}

}
