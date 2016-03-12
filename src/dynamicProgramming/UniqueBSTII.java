package dynamicProgramming;
/*
 * 
 * Leetcode 95. Unique Binary Search Trees II
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
import java.util.*;
import Trees.TreeNode;
public class UniqueBSTII {
    
    private ArrayList<TreeNode> generateTrees(int begin, int end) {
        ArrayList<TreeNode> out = new ArrayList<TreeNode>();
        if (begin == end) {
            TreeNode node = new TreeNode(begin);
            out.add(node);
            return out;
        } else if (begin > end) {
            out.add(null);
            return out;
        }
        for (int i = begin; i <= end; i++) {
            ArrayList<TreeNode> leftSub = generateTrees(begin, i-1);
            ArrayList<TreeNode> rightSub = generateTrees(i+1,end);
            for (TreeNode left:leftSub) {
                for (TreeNode right:rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    out.add(root);
                }
            }
        }
        
        return out;
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new  ArrayList<TreeNode>();
        return generateTrees(1,n);
    }

}
