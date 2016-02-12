package Trees;
/*
 * Leetcode 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class SortedArray2BST {
    
    public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end)
            return null;
        int mid = (begin+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, begin, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, end);
        return node;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

}
