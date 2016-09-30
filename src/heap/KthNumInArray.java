package heap;
/*
 * Leetcode 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 <= k <= array's length.
 */
public class KthNumInArray {
    public int findKth(int[] nums, int start, int end, int k) {

        int pivot = nums[end];
        int left = start;
        int right = end;
        int tmp;
        
        while (true) {
            while (left < right && nums[left] >= pivot)
                left++;
            while (left < right && nums[right] <= pivot)
                right--;
            if (left == right)
                break;
            
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        tmp = nums[left];
        nums[left] = nums[end];
        nums[end] = tmp;

        if (k == left+1)
            return pivot;
        else if (k < left +1)
            return findKth(nums, start, left-1, k);
        
        return findKth(nums, left+1, end, k);
        
    }
    
    public int findKth2(int[] nums, int start, int end, int k) {
        int pivot = nums[(start+end)/2];
        int left = start;
        int right = end;
        int tmp;
        while (left <= right) {
            while ( nums[left] > pivot )
                left++;
            while (nums[right] < pivot)
                right--;
            if (left <= right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        if (start > right && k <= right)
            return findKth2(nums, start,right,k);
        if (left < end && k >= left)
            return findKth2(nums, left,end,k);
        return nums[k];
    }
    public int findKthLargest(int[] nums, int k) {
        return findKth2(nums, 0, nums.length-1, k-1);
    }
    public static void main(String args[]) {
        KthNumInArray k = new KthNumInArray();
        int[] array1 = {1};
        System.out.println(k.findKthLargest(array1, 1));
    }
}
