package Trees;
/*
 * Leetcode 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;
public class BTPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if (root == null)
            return out;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return out;
    }

}
