package Trees;

/*
 * Leetcode 979. Distribute Coins in Binary Tree
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  
(The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.
 */
public class DistributeCoinsBT {
    
    private int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        traverse(root);
        return moves;
    }
    
    public int traverse(TreeNode node) {
        if (node == null)
            return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

}
