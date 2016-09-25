package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 307. Range Sum Query - Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    // traditional solution, update complex is O(n), sum complex is O(1)
    public static class NumArray2 {
        int num[];
        int sums[];

        public NumArray2(int[] nums) {
            if (nums == null || nums.length < 1) {
                sums = null;
                return;
            }

            num = Arrays.copyOf(nums, nums.length);
            sums = new int[nums.length+1];
            sums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }
        }

        void update(int i, int val) {
            if (sums == null)
                return;
            int delta = val - num[i];
            if (delta == 0)
                return;
            num[i] = val;
            for (int idx = i+1; idx < sums.length; idx++)
                sums[idx] += delta;
        }

        public int sumRange(int i, int j) {
            if (sums == null)
                return 0;
            return sums[j+1] - sums[i];
        }
    }
    // segment tree solution, update complex is O(logN), 
    public static class SegTree {
        public SegTree left;
        public SegTree right;
        public int sum;
        int start;
        int end;
        public SegTree(int s, int e) {
            start = s;
            end = e;
            sum = 0;
            left = null;
            right = null;
        }
    }
    
    public static class NumArray {
        SegTree tree;
        
        
        public NumArray(int nums[]) {
            if (nums == null || nums.length < 1) {
                tree =null;
                return;
            }
            tree = buildTree(nums, 0, nums.length-1);
        }
        
        public SegTree buildTree(int nums[], int i, int j) {
            if (j < i)
                return null;
            SegTree node = new SegTree(i, j);
            if (i == j) {
                node.sum = nums[i];
                return node;
            }
            int mid = (i + j)/2;
            node.left = buildTree(nums, i, mid);
            node.right = buildTree(nums, mid+1, j);
            if (node.left != null)
                node.sum += node.left.sum;
            if (node.right != null)
                node.sum += node.right.sum;
            return node;
        }
        
        public int sumRangeHelper(SegTree node, int i, int j) {
            // not in this range, return 0
            if (node == null || j < node.start || i > node.end)
                return 0;
            // totally cover this range, return the sum
            if (i <= node.start && j >= node.end)
                return node.sum;
            int mid = (node.start + node.end)/2;
            int result = sumRangeHelper(node.left, i, Math.min(mid, j)) +
                    sumRangeHelper(node.right, Math.max(mid+1, i), j);
            return result;
        }
        
        public int sumRange(int i, int j) {
            return sumRangeHelper(tree, i, j);
        }
        
        
        public void updateHelper(SegTree node, int i, int val) {
            if (node == null)
                return;
            
            if (node.start == node.end && node.start == i) {
                node.sum = val;
                return;
            }
            
            int mid = (node.start + node.end)/2;
            if (i <= mid) {
                updateHelper(node.left, i, val);
            } else {
                updateHelper(node.right, i, val);
            }
            
            node.sum = node.left.sum + node.right.sum;
        }
        
        public void update(int i, int val) {
            updateHelper(tree, i, val);
        }
        
    }
    
    public static void  main(String args[]) {
        int test[] = {1, 3, 5};
        NumArray2 n = new RangeSumQueryMutable.NumArray2(test);
        System.out.println(n.sumRange(0, 2));
        n.update(1, 2);
        System.out.println(n.sumRange(0, 2));
    }

}
