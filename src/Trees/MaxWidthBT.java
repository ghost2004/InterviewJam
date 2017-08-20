package Trees;
/*
 * Leetcode 662. Maximum Width of Binary Tree
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum 
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the 
level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
 */
import java.util.*;


public class MaxWidthBT {
    private class NodeTrack {
        TreeNode node;
        int idx;
        public NodeTrack(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        

        LinkedList<NodeTrack> cur = new LinkedList<NodeTrack>();
        
        NodeTrack first = new NodeTrack(root, 0);
    
        int max = 0;

        cur.offer(first);
        
        while (!cur.isEmpty()) {
            int minIdx = cur.peek().idx;
            int maxIdx = cur.peek().idx;
            LinkedList<NodeTrack> next = new LinkedList<NodeTrack>();
            
            while (!cur.isEmpty()) {
                NodeTrack t = cur.poll();
                NodeTrack tn;
                minIdx = Math.min(minIdx, t.idx);
                maxIdx = Math.max(maxIdx, t.idx);
                
                if (t.node.left != null) {
                    tn = new NodeTrack(t.node.left, 2*t.idx);
                    next.offer(tn);
                }
                
                if (t.node.right != null) {
                    tn = new NodeTrack(t.node.right, 2*t.idx+1);
                    next.offer(tn);
                }
                    
            }
            
            cur = next;
            if (minIdx == maxIdx) 
                max = Math.max(max, 1);
            else
                max = Math.max(max, maxIdx-minIdx+1);
        }
        
        return max;
    }
}
