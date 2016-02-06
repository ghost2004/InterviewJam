package Trees;
/*
 * Leetcode 124. Binary Tree Maximum Path Sum
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node
 in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BTMaxPathSum {
    
    private int findMax(TreeNode node, int[] max) {
        if (node == null)
            return 0;
        int leftValue = findMax(node.left, max);
        int rightValue = findMax(node.right, max);
        
        int exportValue = node.val + Math.max(leftValue, rightValue);
        exportValue =  Math.max(exportValue, node.val);
        
        int localValue = node.val + leftValue + rightValue;
        max[0] = Math.max(max[0] , exportValue);
        max[0] = Math.max(max[0] , localValue);
        return exportValue;
        
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int max[] = {Integer.MIN_VALUE};
        findMax(root, max);
        return max[0];
    }
}
