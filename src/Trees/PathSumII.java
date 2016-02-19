package Trees;
/*
 * Leetcode 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.*;
public class PathSumII {
    private void search(TreeNode node, int key, ArrayList<Integer> list, List<List<Integer>> result) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (node.val == key) {
                ArrayList<Integer> k = new ArrayList<Integer>(list);
                k.add(node.val);
                result.add(k);
            }
            return;
        }
        int index = list.size();
        list.add(node.val);
        search(node.left, key-node.val, list, result);
        search(node.right, key-node.val, list, result);
        list.remove(index);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        search(root, sum, list, out);
        return out;
    }
}
