package Trees;
/*
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the 
 * BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */

import java.util.*;
public class TwoSumIV {
    
    private void inorder(TreeNode node, ArrayList<Integer> array) {
        if (node == null)
            return;
        inorder(node.left, array);
        array.add(node.val);
        inorder(node.right, array);
    }
    

    public boolean findTarget(TreeNode root, int k) {
        
        
        ArrayList<Integer> array  = new ArrayList<Integer>();
        inorder(root, array);
        
        int left = 0;
        int right = array.size()-1;
        
        while (left < right) {
            int sum = array.get(left) + array.get(right);
            if ( sum == k)
                return true;
            else if (sum < k)
                left++;
            else
                right--;
            
        }
        
        return false;
        
    }

}
