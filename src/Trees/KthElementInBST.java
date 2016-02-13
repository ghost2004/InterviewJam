package Trees;
/*
 * Leetcode 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the 
 * kth smallest element in it.

Note: 
You may assume k is always valid, 1<= k <= BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you 
need to find the kth smallest frequently? How would you optimize the 
kthSmallest routine?
 */
public class KthElementInBST {
    
    private int findKth(TreeNode node, int k, int p[]) {
        if (node == null)
            return 0;
        int leftNum = findKth(node.left, k, p);
        if (leftNum >= k)
            return leftNum+1;
        if (leftNum == k-1) {
            p[0] = node.val;
            return k;
        }
        int rightNum = findKth(node.right, k-leftNum-1, p);
        return (leftNum+rightNum+1);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        int p[] = new int[1];
        findKth(root,k,p);
        
        return p[0];
    }

}
