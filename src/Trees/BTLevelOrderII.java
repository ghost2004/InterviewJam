package Trees;
/*
 * Leetcode 107. Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
import java.util.*;
public class BTLevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (root == null)
            return out;
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        
        Queue<TreeNode> cur;
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        
        next.offer(root);
        
        while (!next.isEmpty()){
            List<Integer> row = new ArrayList<Integer>();
            cur =  next;
            next = new LinkedList<TreeNode>();
            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
                row.add(node.val);
            }
            stack.push(row);
        }
        
        while (!stack.isEmpty())
            out.add(stack.pop());
        
        
        
        return out;
    }
}
