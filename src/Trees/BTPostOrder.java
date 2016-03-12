package Trees;
/*
 * Leetcode 145. Binary Tree Postorder Traversal
 * 
 *  Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class BTPostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if (root == null)
            return out;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (prev == null || node == prev.left || node == prev.right) {
                if (node.left != null) {
                    stack.push(node.left);
                } else if (node.right != null) {
                    stack.push(node.right);
                } else {
                    stack.pop();
                    out.add(node.val);
                }
                    
            } else if (node.left == prev) {
                if (node.right != null) {
                    stack.push(node.right);
                } else {
                    stack.pop();
                    out.add(node.val);
                }
           } else if (node.right == prev) {
               stack.pop();
               out.add(node.val);
           }
            
            
            prev = node;
            
        }
        
        return out;
    }

}
