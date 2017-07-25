package arrays;

import java.util.Arrays;

/*
 * Leetcode 646. Maximum Length of Pair Chain
 * 
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed 
in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. 
You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].
 */
public class MaxPairChain {
    
    private class Pairs implements Comparable<Pairs> {
        int val1;
        int val2;
        public Pairs(int x, int y) {
            this.val1 = x;
            this.val2 = y;
        }
        public int compareTo(Pairs other) {
            return this.val1 - other.val1;
        }
    }
    public int findLongestChain(int[][] pairs) {
        int count = pairs.length;
        if (count < 2 )
            return count;
        Pairs[] array = new Pairs[count];
        
        for (int i =0 ; i < count; i++) {
            array[i] = new Pairs( pairs[i][0], pairs[i][1]);
        }
        
        Arrays.sort(array);
        int max = 1;
        int dp[] = new int[count+1];
        
        dp[0] = 1;


        for (int i = 1; i < count; i++) {
            int j = i-1;
            while (j >= 0 && array[i].val1 <= array[j].val2)
                j--;
            if (j < 0)
                dp[i] = 1;
            else 
                dp[i] = dp[j]+1;
            
            max = Math.max(max, dp[i]);
            
        }
        return max;
    }
    
    
    public static void main(String args[]) {
        int a1[][] = {{1,2}, {2,3}, {3,4}};
        MaxPairChain m = new MaxPairChain();
        System.out.println(m.findLongestChain(a1));
        
    }
    /*
    private class IntervalTree {
        int begin;
        int end;
        int cnt;
        IntervalTree left;
        IntervalTree right;
        
        public IntervalTree(int x, int y) {
            this.begin = x;
            this.begin = y;
            this.cnt = 1;
        }
        
        public int insert(IntervalTree node) {
            int cnt = 0;
            
            
            return cnt;
        }
    }
    
    */

}
