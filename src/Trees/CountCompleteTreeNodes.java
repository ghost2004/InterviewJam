package Trees;
/*
 * Leetcode 222. Count Complete Tree Nodes
 * 
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the 
last, is completely filled, and all nodes in the last level
 are as far left as possible. It can have between 1 and 2h 
 nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int height_left = 0;
        int height_right = 0;
        
        TreeNode cur = root.left;
        while (cur != null) {
            cur = cur.left;
            height_left++;
        }
        
        cur = root.right;
        while (cur != null) {
            cur = cur.right;
            height_right++;
        }
        
        if (height_left == height_right)
            return 2<<height_left-1;
        
        return 1+countNodes(root.left) + countNodes(root.right);
    }

}
