package Trees;
/*
 * Leetcode 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from
 the root node down to the nearest leaf node.
 */
public class MinDepthofBT {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        
        int left = Integer.MAX_VALUE;
        
        int right = Integer.MAX_VALUE;
        
        if (root.left != null)
            left = minDepth(root.left);
        if (root.right != null)
            right = minDepth(root.right);
        
        return Math.min(left, right)+1;
    }
}
