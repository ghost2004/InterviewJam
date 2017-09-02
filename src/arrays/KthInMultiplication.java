package arrays;
/*
 * Leetcode 668. Kth Smallest Number in Multiplication Table
 * 
 * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest 
 * number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, 
you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output: 
Explanation: 
The Multiplication Table:
1   2   3
2   4   6
3   6   9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output: 
Explanation: 
The Multiplication Table:
1   2   3
2   4   6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
Note:
The m and n will be in the range [1, 30000].
The k will be in the range [1, m * n]
 */
public class KthInMultiplication {
    // given value , return its position in m*n matrix
    private int count(int value, int m, int n) {
        // start from left-down corner
        int i = m;
        int j = 1;
        int count = 0;
        // search to right-up corner
        while ( i >= 1 && j <= n) {
            if (i*j <= value) {
                // move right, add current column size
                j++;
                count +=  i;
            }
            else
                // move up
                i--;
        }
        
        
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        // binary search, range from 1 to m*n
        
        while (left < right) {
            int mid = (left + right)/2;
            // get the position of middle number
            int cnt = count(mid, m, n);
            if (cnt < k)
                // move to right half 
                left = mid+1;
            else 
                right = mid;
                
        }
        
        return right;
    }
}
