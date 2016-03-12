package Trees;
/*
 * Leetcode 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.*;
public class BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (root == null)
            return out;
        
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();        
        next.offer(root);
        
        while (!next.isEmpty()) {
            cur = next;
            next = new LinkedList<TreeNode>();  
            List<Integer> list = new ArrayList<Integer>();
            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
                list.add(node.val);
            }
            out.add(list);
        }
        
        
        return out;
    }

}
