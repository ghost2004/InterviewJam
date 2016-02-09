package Trees;
/*
 * Leetcode 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
import java.util.*;
public class BTPaths {
    private void dfs(TreeNode node, String str,List<String> result ) {

        if (node.left == null && node.right == null) {
            result.add(str);
            return;
        }
        if (node.left != null) 
            dfs(node.left, str+"->"+String.valueOf(node.left.val), result);
        if (node.right != null)
            dfs(node.right, str+"->"+String.valueOf(node.right.val), result);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList<String>();
        if (root == null)
            return out;
        dfs(root, String.valueOf(root.val), out);
        return out;
    }

}
