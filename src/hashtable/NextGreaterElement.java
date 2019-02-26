package hashtable;
/*
 * Leetcode 496. Next Greater Element I
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1¡¯s elements are subset of nums2. Find all the 
 * next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, 
output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 */
import java.util.*;
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // the map from value to its next greater element
        HashMap<Integer, Integer> map = new HashMap<>();
        // the stack to keep track of current biggest element
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums2) {
            // num is greater than the peek number of stack, which means it is the next greater element of it
            while (!stack.isEmpty() && stack.peek() < num) {
                // pop out the peek number, put current number into map
                map.put(stack.pop(), num);
            }
            // push current number into stack, looking for its next greater element in the future
            stack.push(num);
        }
        
        
        int out[] = new int[nums1.length];
        for (int i =0; i < nums1.length; i++) {
            // get the next greater element from map, or return -1 if it is not in map
            out[i] = map.getOrDefault(nums1[i], -1);
        }
        return out;
    }

}
