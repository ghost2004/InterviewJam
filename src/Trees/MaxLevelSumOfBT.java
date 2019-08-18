package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Leetcode 5052. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

 

Example 1:



Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 

Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
 */
public class MaxLevelSumOfBT {
    private class TreeLevelNode {
        TreeNode _node;
        int _level;
        TreeLevelNode (TreeNode node, int level) {
            _node = node;
            _level = level;
        }
        
    }
    
    public int maxLevelSum(TreeNode root) {
        Queue<TreeLevelNode> queue = new LinkedList<>();
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        int curLevel = 0;
        int curSum = Integer.MIN_VALUE;
        queue.offer(new TreeLevelNode(root, 1));
        while (!queue.isEmpty()) {
            TreeLevelNode cur = queue.poll();
            
            if (cur._level > curLevel) {
                if (curSum > maxSum) {
                    maxLevel = curLevel;
                    maxSum = curSum;
                }
                curSum = 0;
                curLevel = cur._level;
            }
            curSum += cur._node.val;
            
            if (cur._node.left != null)
                queue.offer(new TreeLevelNode(cur._node.left , cur._level + 1));
            if (cur._node.right != null)
                queue.offer(new TreeLevelNode(cur._node.right , cur._level + 1));
        }
        
        return maxLevel;
        
    }

}
