package Trees;
/*
 * Leetcode 114. Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBT2List {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root.left;
        if (cur != null) {
            while (cur.right != null)
                cur = cur.right;
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        flatten(root.right);
    }

}
