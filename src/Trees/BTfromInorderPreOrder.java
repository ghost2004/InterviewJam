package Trees;
/*
 * Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class BTfromInorderPreOrder {
    private TreeNode buildTree(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return null;
        
        node.left = buildTree(preorder, preStart+1, preStart+idx-inStart, inorder, inStart, idx-1);
        node.right = buildTree(preorder, preStart+idx+1-inStart, preEnd, inorder, idx+1, inEnd);
        return node;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        
    }

}
