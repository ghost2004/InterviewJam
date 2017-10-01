package Trees;
/*
 * Leetcode 687. Longest Univalue Path
 * Given a binary tree, find the length of the longest path where each node in the path has 
 * the same value. This path may or may not pass through the root.

    Note: The length of path between two nodes is represented by the number of 
    edges between them.
    
    Example 1:
    
    Input:
    
                  5
                 / \
                4   5
               / \   \
              1   1   5
    Output:
    
    2
    Example 2:
    
    Input:
    
                  1
                 / \
                4   5
               / \   \
              4   4   5
    Output:
    
    2
    Note: The given binary tree has not more than 10000 nodes. The height of the tree 
    is not more than 1000.
 */
public class LongestUnivaluePath {

    private int dfs(TreeNode node, int num[] ) {
        int leftV = node.left != null ? dfs(node.left, num) : 0;
        int rightV = node.right != null ? dfs(node.right, num) : 0;
        int leftCnt = node.left != null && node.left.val == node.val ? 1 + leftV: 0 ;
        int rightCnt = node.right != null && node.right.val == node.val ? 1 + rightV: 0;
        num[0] = Math.max(num[0], leftCnt + rightCnt);
        
        return Math.max(leftCnt, rightCnt);
        
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        int num[] = new int[1];
        dfs(root, num);
        return num[0];
    }
}
