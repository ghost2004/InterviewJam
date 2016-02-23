package Trees;
/*
 * 
 * Leetcode 298 Binary Tree Longest Consecutive Sequence
 * Problem Description:

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the
 tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BTLongestConsecutiveSeq {
    private int dfs(TreeNode node, TreeNode parent, int length) {
        int curLen = 1;
        if (node == null)
            return length;
        if (parent != null && parent.val + 1 == node.val) {
            curLen = length+1;
        } 
        
        return Math.max(Math.max(length, dfs(node.left,node, curLen)), dfs(node.right, node, curLen));
            
            
    }
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }
}
