package Trees;
/*
 * Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class BTfromInorderPostOrder {
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        if (inStart == inEnd)
            return node;
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++ ) {
            if (inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return null;
        
        node.left = buildTree(inorder, inStart, idx-1, postorder, postStart, postStart+idx-inStart-1);
        node.right = buildTree(inorder, idx+1, inEnd, postorder, postStart+idx-inStart, postEnd-1);
        
        return node;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

}
