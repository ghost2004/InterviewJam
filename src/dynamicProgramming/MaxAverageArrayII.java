package dynamicProgramming;
/*
 * Leetcode 644. Maximum Average Subarray II
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k 
 * that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation:
when length is 5, maximum average value is 10.8,
when length is 6, maximum average value is 9.16667.
Thus return 12.75.
Note:
1 <= k <= n <= 10,000.
Elements of the given array will be in range [-10,000, 10,000].
The answer with the calculation error less than 10^-5 will be accepted.
 */
public class MaxAverageArrayII {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        double avg = 0;
        long total = 0;
        int idx = 0;
        int left = 0;
        while (idx < k) {
            total += nums[idx];
            idx++;
        }
        
        avg = 1.0*total/k;
        
        while (left < nums.length -k) {
            long t2 = total;
            
            for (int right = idx; right < nums.length; right++) {
                t2 += nums[right];
                if (t2 > avg*(right-left+1)) 
                    avg = 1.0*t2/(right - left +1);
            }

            total += nums[idx] - nums[left];
            avg  = Math.max(avg, 1.0*total/k);
            
            left++;
            idx++;
        }
        
        return avg;
        
    }
    
    public double findMaxAverageII(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        int i;
        double maxAvg=0,avg = 0;
        long sum = 0;
        int len = k;
        
        // get the average of first k elements
        for (i = 0; i < k; i++) 
            sum += nums[i];
        
        maxAvg = 1.0*sum/k;
        
        // for each max average ends at position i
        for (i = k; i < nums.length; i++ ) {
            // increase length and get first average
            len++;
            sum += nums[i];
            avg = 1.0* sum / len;
            
            long tmpSum = sum;
            double tmpAvg = avg;
            // right shift the start of window
            for (int j = len-1; j >= k; j--) {
                tmpSum -= nums[i-j];
                tmpAvg = tmpSum/j;
                // once found better solution, mark the length and sum
                if (tmpAvg >= avg) {
                    len = j;
                    sum = tmpSum;
                    avg = tmpAvg;
                }
            }
            
            maxAvg = Math.max(maxAvg, avg);
            
        }
        
        
        
        return maxAvg;
        
        
    }
    
    public static void main(String args[]) {
        MaxAverageArrayII m = new MaxAverageArrayII();
        int a1[] = {1,12,-5,-6,50,3};
        
        System.out.println(m.findMaxAverageII(a1, 4));
        
    }

}
