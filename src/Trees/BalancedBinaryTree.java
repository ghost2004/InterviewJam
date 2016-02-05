package Trees;
/*
 * Leetcode 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the 
depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    
    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left < 0 || right < 0)
            return -1;
        if (Math.abs(right - left) > 1 )
            return -1;
        
        return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        
        return (depth >=0 ? true:false);
    }

}
