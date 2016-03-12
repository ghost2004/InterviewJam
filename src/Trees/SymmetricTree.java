package Trees;
/*
 * Leetcode 101. Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
import java.util.*;
public class SymmetricTree {
    // recursively sloution
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        
        if (left.val != right.val)
            return false;
        
        return isSymmetric(left.left, right.right) && isSymmetric (left.right, right.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    
    // iteratively solution
    public boolean isSymmetricIter(TreeNode root) {
        if (root == null)
            return true;
        
        LinkedList<TreeNode> leftSub = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightSub = new LinkedList<TreeNode>();
        
        leftSub.offer(root.left);
        rightSub.offer(root.right);
        
        while (!leftSub.isEmpty() && !rightSub.isEmpty()) {
            TreeNode left = leftSub.poll();
            TreeNode right = rightSub.poll();
            
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            
            if (left.val != right.val)
                return false;
            leftSub.offer(left.left);
            leftSub.offer(left.right);
            rightSub.offer(right.right);
            rightSub.offer(right.left);
            
        }
        
        return leftSub.isEmpty() && rightSub.isEmpty();
    }

}
