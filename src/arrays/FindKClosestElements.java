package arrays;
/* Leetcode 658. Find K Closest Elements
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements
 *  are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 10^4
Absolute value of elements in the array and x will not exceed 10^4
 */
import java.util.*;
public class FindKClosestElements {
    
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        LinkedList<Integer> out = new LinkedList<>();
        int left = 0;
        int right = arr.size()-1;
        if (x < arr.get(left)) {
            left = -1;
            right = 0;
        } else if (x > arr.get(right)) {
            left = right;
            right = right+1;
        } else {
            while (left <= right) {
                int mid = (left+right)/2;
                if (arr.get(mid) == x) {
                    out.add(x);
                    left = mid-1;
                    right = mid + 1;

                    break;
                } else if (arr.get(mid) < x) {
                    left = mid+1;
                } else {
                    right = mid -1;
                }
                
            }
            if (left >= right)
                left = right -1;
            
        }
        
        while (out.size() < k) {
            if (left < 0) {
                out.addLast(arr.get(right++));
            } else if (right >= arr.size()) {
                out.addFirst(arr.get(left--));
            } else {
                int c1 = arr.get(left);
                int c2 = arr.get(right);
                if (x - c1 <= c2 - x) {
                    out.addFirst(arr.get(left--));
                } else {
                    out.addLast(arr.get(right++));
                }
            }
        }
        
        return out;
    }
    
    public static void main(String args[]) {
        FindKClosestElements f = new FindKClosestElements();
        /*
        Integer t1[] = {1,2,3,4,5};
        System.out.println(f.findClosestElements(Arrays.asList(t1), 4, 3));
        System.out.println(f.findClosestElements(Arrays.asList(t1), 4, -1));
        */
        Integer t2[] = {0,1,1,1,2,3,6,7,8,9};
        System.out.println(f.findClosestElements(Arrays.asList(t2), 9, 4));

        
    }
}
