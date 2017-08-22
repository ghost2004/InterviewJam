package Trees;
/*
 * Leetcode 663. Equal Tree Partition
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two 
 * trees which have the equal sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15
Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
Note:
The range of tree node value is in the range of [-100000, 100000].
1 <= n <= 10000
 */
import java.util.*;
public class EqualTreePartition {
    HashSet<Integer> set;
    
    public int checkSum(TreeNode node, boolean check) {
        int value = node.val;
        
        if (node.left != null)
            value += checkSum(node.left, true);
        
        if (node.right != null)
            value += checkSum(node.right, true);
        
        if (check)
            set.add(value);
        
        return value;
        
    }
    
    public boolean checkEqualTree(TreeNode root) {
        
        if (root == null)
            return false;
        set = new HashSet<>();
        
        int sum = checkSum(root, false);
        
        if (sum % 2 != 0)
            return false;

        return set.contains(sum/2);
        
    }

}
