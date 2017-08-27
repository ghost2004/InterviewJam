package arrays;
/*
 * 
 * Leetcode 665. Non-decreasing Array
 * 
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
 */

import java.util.*;
public class NonDecreasingArray {
    

    public boolean check(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1])
                return false;
        }
        return true;
    }
    
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                int a1[] = Arrays.copyOf(nums, nums.length);
                int a2[] = Arrays.copyOf(nums, nums.length);
                a1[i-1] = nums[i];
                a2[i] = nums[i-1];
                return check(a1) || check(a2);
            } 
        }
        
        
        return true;
        
    }
    
    public static void main(String args[]) {
        NonDecreasingArray d = new NonDecreasingArray();
        int arr1[] = { 4,2,3};
        int arr2[] = {4,2,1};
        int arr3[] = {3,4,2,3};
        int arr4[] = {-1,4,2,3};
        int arr5[] = {2,3,3,2,4};
        int arr6[] = {3,3,2,2};
        System.out.println(d.checkPossibility(arr1));
        System.out.println(d.checkPossibility(arr2));
        System.out.println(d.checkPossibility(arr3));
        System.out.println(d.checkPossibility(arr4));
        System.out.println(d.checkPossibility(arr5));
        System.out.println(d.checkPossibility(arr6));
    }

}
