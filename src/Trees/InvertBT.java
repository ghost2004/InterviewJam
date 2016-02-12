package Trees;
/*
 * Leetcode 226. Invert Binary Tree
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBT {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        
        return root;
        
    }

}
