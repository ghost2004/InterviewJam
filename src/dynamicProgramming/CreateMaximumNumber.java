package dynamicProgramming;
/*
 * Leetcode 321. Create Maximum Number
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. The 
 * relative order of the digits from the same array must be preserved. Return
 *  an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]


 */
public class CreateMaximumNumber {
    // find the maximum k numbers in array without changing its order
    public int[] getMaxSub(int[] array, int k) {
        int out[] = new int[k];
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            // move the pointer back only when both condition happens
            // 1. current element is larger than last one in candidate
            // 2. there are enough elements in rest of array
            while (idx > 0 && array.length - i + idx > k && out[idx-1] < array[i]) {
                idx--;
            }
            if (idx < k)
                out[idx++] = array[i];
        }
        return out;
    }

    // compare the array
    public boolean arrayGreater(int[] left, int idx1, int[] right, int idx2) {
        
        for (; idx1 < left.length && idx2<right.length; idx1++,idx2++) {
            if (left[idx1] > right[idx2])
                return true;
            else if (left[idx1] < right[idx2])
                return false;
        }
        return idx1 != left.length;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;


        int out[] = new int[k];
        int start = Math.max(0, k - len2);
        int end = Math.min(k, len1);
        // get all the combination of get k from 2 arrays
        for (int i = start; i <= end; i++) {
            int left[] = getMaxSub(nums1, i);
            int right[] = getMaxSub(nums2,k-i);
            int array[] = new int[k];
            int leftIdx = 0, rightIdx = 0, idx = 0;
            while (leftIdx < left.length || rightIdx < right.length) {
                array[idx++] = arrayGreater(left, leftIdx, right, rightIdx) ? left[leftIdx++]:right[rightIdx++];
            }
                
            if (arrayGreater(array,0, out,0))
                out = array;
        }
        return out;
    }
    
    public static void main(String args[]) {
        CreateMaximumNumber c = new CreateMaximumNumber();
       
        int nums1[] = {3, 4, 6, 5};
        int nums2[] = {9, 1, 2, 5, 8, 3};
        int out[] = c.maxNumber(nums1, nums2, 5);
        for (int i:out) {
            System.out.print(i+" ");
        }
        System.out.println();
       
        int nums3[] = {4,9,5};
        int nums4[] = {8,7,4};

        out = c.maxNumber(nums3, nums4, 3);
        for (int i:out) {
            System.out.print(i+" ");
        }
        System.out.println();
        
    }
}
