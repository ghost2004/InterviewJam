package Trees;
/*
 * 
 * Leetcode 650. 2 Keys Keyboard
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
    HashMap<Integer, ArrayList<TreeNode>> map;
    
    private void travel(TreeNode node) {
        if (node == null)
            return;
        
        ArrayList<TreeNode> list = map.get(node.val);
        if (list == null) {
            list = new ArrayList<TreeNode>();
            map.put(node.val, list);
        } 
        
        list.add(node);
        travel(node.left);
        travel(node.right);
    }
    
    private boolean compareTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        
        if (a.val != b.val)
            return false;
        
        return compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> out = new ArrayList<TreeNode>();

        map = new HashMap<Integer, ArrayList<TreeNode>>();
        travel(root);
        Set<Map.Entry<Integer, ArrayList<TreeNode>>> entryset = map.entrySet();
        
        for (Map.Entry<Integer, ArrayList<TreeNode>> item : entryset) {
            ArrayList<TreeNode> list = item.getValue();
            if (list.size() == 1)
                continue;
            
            for (int i = 0; i < list.size()-1; i++)  {
                TreeNode k1 = list.get(i);
                for (int j = i+1; j < list.size(); j++) {
                    TreeNode k2 = list.get(j);
                    if (compareTree(k1,k2) ){
                        out.add(k1);
                    }
                }
            }
            
        }
        
        
        
        return out;
    }
}
