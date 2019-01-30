package arrays;
/*
 * Leetcode 978. Longest Turbulent Subarray
 * 
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.

 

Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
Example 2:

Input: [4,8,12,16]
Output: 2
Example 3:

Input: [100]
Output: 1
 

Note:

1 <= A.length <= 40000
0 <= A[i] <= 10^9
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length < 1)
            return 0;
        //inc: The length of current valid sequence which ends with two increasing numbers
        int inc = 1;
        //dec: The length of current valid sequence which ends with two decreasing numbers
        int dec = 1;
        // the result
        int result = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) { // current item is larger than last one, 
                // increasing number is  decreasing number plus one
                inc = dec + 1;
                // reset decreasing number
                dec = 1;
            } else if (A[i] < A[i-1]) { // current item is less than last one
                // decreasing number is increasing number plus one
                dec = inc + 1;
                // reset increasing number
                inc = 1;
            } else { // equal case
                // reset increasing number and decreasing number
                inc = 1;
                dec = 1;
            }
            // get current largest one
            result = Math.max(result, Math.max(inc, dec));
        }
        
        
        return result;
    }
}
