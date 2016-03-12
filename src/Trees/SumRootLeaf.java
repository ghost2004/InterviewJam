package Trees;
/*
 * Leetcode 129. Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 *  could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRootLeaf {
    
    private int sumNumbers(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return 10*sum + node.val;
        }
        
        int left = 0;
        if (node.left != null)
            left = sumNumbers(node.left, 10*sum+node.val);
        int right = 0;
        if (node.right != null)
            right  = sumNumbers(node.right, 10*sum+node.val);
        
        return left+right;
    }
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbers(root,0);
    }

}
