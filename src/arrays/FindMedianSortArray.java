package arrays;
/*
 * Leetcode 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class FindMedianSortArray {
    
    private int findKth(int A[], int startA, int B[], int startB,  int k) {
        // case 1:  A[] is empty 
        if (startA >= A.length)
            return B[startB+k-1];
        // case 2: B[] is empty
        if (startB >= B.length)
            return A[startA+k-1];
        // case 3: get the first element
        if (k == 1) 
            return Math.min(A[startA], B[startB]);
        
        int idxA = startA + (k/2) - 1;
        int idxB = startB + (k/2) - 1;
        int keyA, keyB;
        // get the k/2 element from each array
        // if k/2 is out of range , make it infinity
        // Why? Because it means Kth element still can be in this part
        if (idxA >= A.length)
            keyA = Integer.MAX_VALUE;
        else
            keyA = A[idxA];
        
        if (idxB >= B.length)
            keyB = Integer.MAX_VALUE;
        else
            keyB = B[idxB];
        
        if (keyA < keyB) {
            // case 4: key index of A is less than key index of B
            // It means the element can't fit in the left part of A 
            // Keep searching in the right part of A
            return findKth(A, idxA+1, B, startB, k-k/2);
        }
        // case 5: key index of A is greater than key index of B
        // It means the element can't fit in the left part of B
        // Keep searching in the right part of B
        return findKth(A, startA, B, idxB+1, k-k/2);
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int k = (m+n)/2;
        // odd number, get the (m+n)/2+1 element
        if ((m+n)%2 != 0) 
            return (double)findKth(nums1, 0, nums2, 0, k+1);
        // even number, get the average value of k and k+1
        return ((double)findKth(nums1, 0, nums2, 0, k+1) + (double)findKth(nums1, 0, nums2, 0, k))/2;
    }

}
