package Trees;
/*
 * Leetcode 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be 
 * initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
 */
import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int val = cur.val;
        
        cur = cur.right;
        
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        return val;
    }
}
