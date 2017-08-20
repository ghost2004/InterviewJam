package arrays;
/*
 * Leetcode 661. Image Smoother
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to 
 * make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding 
 * cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {
    
    public int getMatrix(int[][] M, int x, int y) {
        if (x < 0 || x >= M.length)
            return -1;
        if (y < 0 || y >= M[0].length )
            return -1;
        
        return M[x][y];
    }
    
    public int getSmoother(int[][] M, int x, int y) {
        int cnt = 0;
        int sum = 0;
        
        for (int i = x-1; i < x+2; i++) {
            for (int j = y-1; j< y+2; j++) {

                int val = getMatrix(M, i, j);
                if (val != -1) {
                    cnt++;
                    sum += val;
                }
                    
            }
            
        }
        if (cnt == 0)
            return 0;
        return (int)(sum/cnt);
        
    }
    
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int sm[][] = new int[m][n];
        
        for  (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sm[i][j] = getSmoother(M, i, j);
            }
        }
        
        return sm;
    }
}
