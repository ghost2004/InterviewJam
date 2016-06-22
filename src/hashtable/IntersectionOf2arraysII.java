package hashtable;
/*
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you 
cannot load all elements into the memory at once?
 */
import java.util.*;
public class IntersectionOf2arraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i:nums1) {
        	Integer cnt = map.get(i);
        	if (cnt == null) {
        		map.put(i, 1);
        	} else {
        		map.put(i, cnt+1);
        	}
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int y:nums2) {
        	Integer cnt = map.get(y);
        	if (cnt != null) {
        		if (cnt > 0) {
        			list.add(y);
            		map.put(y, cnt-1);   			
        		}
        		
        	}
        }
        int result[] = new int[list.size()];
        int idx = 0;
        for (int z:list) {
        	result[idx++] = z;
        }
        return result;
    }
	
	public int[] intersectSorted(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0, p2 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] < nums2[p2]) {
				p1++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				list.add(nums1[p1]);
				p1++;
				p2++;
			}
		}
		int result[] = new int[list.size()];
        int idx = 0;
        for (int z:list) {
        	result[idx++] = z;
        }
        return result;
	}
}
