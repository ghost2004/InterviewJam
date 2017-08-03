package Trees;
/*
 * 
 * Leetcode 652. Find Duplicate Subtrees
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
 * you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.
 */
import java.util.*;

public class DuplicateSubTree {
    HashMap<String, TreeNode> dict;
    
    private String travel(TreeNode node) {
        if (node == null)
            return "#";
        
        String serial = node.val + "|" + travel(node.left) + "|" + travel(node.right);
        
        if (dict.containsKey(serial)) {
            dict.put(serial, node);
        } else {
            dict.put(serial, null);
        }
        
        return serial;
    }
    

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> out = new ArrayList<TreeNode>();

        dict = new HashMap<String, TreeNode>();
        travel(root);

        for (TreeNode n:dict.values()) {
            if (n != null) {
                out.add(n);
            }
        }
        
        return out;
    }
}
