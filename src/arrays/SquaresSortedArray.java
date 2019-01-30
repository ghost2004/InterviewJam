package arrays;
/*
 * Leetcode 977. Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, 
 * also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length < 1) {
            return A;
        }
        int[] out = new int[A.length];
        int left = 0;
        int right = A.length-1;
        int index = right;
        
        while (left <= right) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                out[index] = A[right] * A[right];
                right--;
            } else {
                out[index] = A[left] * A[left];
                left++;
            }
            index--;
        }
        
        return out;
        
    }
}
