package Trees;
/*
 * Leetcode 94. Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class BTInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if (root == null)
            return out;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        while (!stack.isEmpty()) {
            node = stack.pop();
            out.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return out;
    }
}
