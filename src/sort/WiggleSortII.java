package sort;

import java.util.Arrays;

/*
 * Leetcode 324. Wiggle Sort II
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    public void wiggleSort2(int[] nums) {
        
        int tmp[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int idx1 = (nums.length-1)/2;
        int idx2 = nums.length-1;
        for (int i = 0; i < nums.length; i++ ) {
            if (i % 2 == 0) 
                nums[i] = tmp[idx1--];
            else
                nums[i] = tmp[idx2--];
        }

    }
    
    public void dumpArray(int[] array) {
        for (int i:array) 
            System.out.print(i+" ");
        System.out.println();
    }
    
    
    public int partition(int nums[], int start, int end, int k) {
        int left = start, right = end;
        int pivot = nums[left];

        while (left < right) {
            while (left < right && pivot <= nums[right])
                right --;
            nums[left] = nums[right];
            while (left < right && pivot >= nums[left])
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        if (left == k)
            return left;
        else if (left < k) 
            return partition(nums, left+1, end,k);
        return partition(nums, start, left-1,k);
        
    }
    public void wiggleSort(int[] nums) {
        int mid = partition(nums, 0, nums.length-1, nums.length/2);
        mid = nums[mid];
        
        dumpArray(nums);
        int[] ans = new int[nums.length];
        Arrays.fill(ans, mid);

        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        dumpArray(ans);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

    }
    
    public static void main(String args[]) {
        int array[] = {1,3,2,2,3,1};
        int array2[] = {2,1};
        WiggleSortII w = new WiggleSortII();
        w.wiggleSort(array);
        w.dumpArray(array);
    }
}
