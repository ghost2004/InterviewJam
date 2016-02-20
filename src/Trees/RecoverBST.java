package Trees;
/*
 * Leetcode 99. Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?
 */
public class RecoverBST {
    
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;
    
    private void findTree(TreeNode node) {
        if (node.left != null) 
            findTree(node.left);
        if (prev != null && prev.val > node.val ) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        
        prev = node;
        
        if (node.right != null)
            findTree(node.right);
        
    }
    
    public void recoverTree(TreeNode root) {
        findTree(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
