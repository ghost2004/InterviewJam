package hashtable;
/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */
import java.util.*;

public class IntersectionOf2arrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> in = new HashSet<Integer>();
        HashSet<Integer> out = new HashSet<Integer>();
        
        for (int x:nums1) {
        	in.add(x);
        }
        
        for (int y:nums2) {
        	if (in.contains(y))
        		out.add(y);
        }
        
        int result[] = new int[out.size()];
        int idx = 0;
        for (int x:out) {
        	result[idx++] = x;
        }
        
        return result;
    }
}
