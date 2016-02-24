package dynamicProgramming;
/*
 * Leetcode 96. Unique Binary Search Trees
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBST {
    public int numTrees(int n) {
        if (n <= 2)
            return n;
        int num[] = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        num[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j]*num[i-j-1];
            }
        }
        return num[n];
    }

}
