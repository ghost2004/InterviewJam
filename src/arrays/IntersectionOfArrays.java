package arrays;
/*
 * Leetcode 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

 */

import java.util.*;
public class IntersectionOfArrays {
    public int[] intersection_Set(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> out = new HashSet<>();
        
        for (int i:nums1) {
            set1.add(i);
        }
        
        for (int i:nums2) {
            if (set1.contains(i))
                out.add(i);
        }
        
        int res[] = new int[out.size()];
        int idx = 0;
        for (int i:out) {
            res[idx++] = i;
        }
        
        return res;
    }
    
    public int[] intersection_Sort(int[] nums1, int[] nums2) {
        HashSet<Integer> out = new HashSet<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2])
                idx1++;
            else if (nums1[idx1] > nums2[idx2])
                idx2++;
            else {
                out.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
                
        }
        
        int res[] = new int[out.size()];
        int idx = 0;
        for (int i:out) {
            res[idx++] = i;
        }
        
        return res;
        
    }
}
