package Trees;
/*
 * Leetcode 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, return the values
 *  of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
import java.util.*;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> cur;
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        next.offer(root);
        
        while (!next.isEmpty()) {
            cur = next;
            next = new LinkedList<TreeNode>();

            result.add(cur.getFirst().val);
            
            while (!cur.isEmpty()){
                TreeNode node = cur.poll();
                if (node.right != null) 
                    next.offer(node.right);
                if (node.left != null)
                    next.offer(node.left);
            }
            
        }
        
        return result;
    }

}
