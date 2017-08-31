package Trees;
/*
 * Leetcode 666. Path Sum IV
 * 
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list 
 * of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. 
The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller 
than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
 */
import java.util.*;

public class PathSumIV {
    int sum = 0;
    HashMap<Integer, Integer> map;
    
    private void travel(int node, int preSum) {
        int level = node/10;
        int pos = node % 10;
        int leftChild = (level+1)*10 + 2*pos -1;
        int rightChild = (level+1)*10 + 2*pos;
        int val = map.get(node);
        // It is the leaf
        if (!map.containsKey(leftChild) && !map.containsKey(rightChild)) {
            sum += preSum + val;
            return;
        }
        
        if (map.containsKey(leftChild))
            travel(leftChild, preSum+val);
        if (map.containsKey(rightChild))
            travel(rightChild, preSum+val);
            
       
    }
    public int pathSum(int[] nums) {
        map = new HashMap<>();
        sum = 0;
        for (int i:nums) {
            int key = i / 10;
            int val = i % 10;
            map.put(key, val);
        }
        travel(nums[0]/10, 0);
        return sum;
    }
}
