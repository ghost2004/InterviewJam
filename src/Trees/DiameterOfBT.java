package Trees;
/*
 * Leetcode 543. Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the
 *  longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBT {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxDepth(root); 
        return max;
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
        
    }

}
