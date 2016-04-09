package sort;
/*
 * Leetcode 164. Maximum Gap
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        else if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);
        
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int minGap = (max - min) / nums.length + 1;
        int buckets = (max - min) / minGap + 1;
        
        boolean filled[] = new boolean[buckets];
        int minBucket[] = new int[buckets];
        int maxBucket[] = new int[buckets];
        
        for (int i = 0; i < nums.length;i++) {
            int idx = (nums[i] - min)/minGap;
            if (!filled[idx]) {
                minBucket[idx] = nums[i];
                maxBucket[idx] = nums[i];
                filled[idx] = true;
            } else {
                minBucket[idx] = Math.min(minBucket[idx], nums[i]);
                maxBucket[idx] = Math.max(maxBucket[idx], nums[i]);
                
            }
        }
        
        int maxGap = 0;
        int prev = 0;
        for (int i = 1; i < buckets; i++) {
            if (filled[i]) {
                maxGap = Math.max(maxGap, minBucket[i] - maxBucket[prev]);
                prev = i;
            }   
        }
        
        return maxGap;
    }
    
    public static void main(String args[]) {
        MaximumGap gap = new MaximumGap();
        int t1[] = {3,6,9,1};
        System.out.println(gap.maximumGap(t1));
    }
}
