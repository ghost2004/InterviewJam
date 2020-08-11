package Trees;
/*
 * Leetcode 958. Check Completeness of a Binary Tree
 * 
 * Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
 */
import java.util.*;
public class CompletenessBT {
    public boolean isCompleteTree(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hitNullNode = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (hitNullNode)
                    return false;
                queue.offer(node.left);
            } else {
                hitNullNode = true;
            }
            
            if (node.right != null) {
                if (hitNullNode)
                    return false;
                queue.offer(node.right);
            } else
                hitNullNode = true;
            
        }
        
        return true;
    }

}
