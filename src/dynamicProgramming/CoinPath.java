package dynamicProgramming;
/*
 * Leetcode 656. Coin Path
 * 
 * Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B. 
 * The integer B denotes that from any place (suppose the index is i) in the array A, you can jump
 *  to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to.
 *  Also, if you step on the index i, you have to pay Ai coins. If Ai is -1, it means you can’t jump
 *   to the place indexed i in the array.

Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N 
using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array 
you should take to get to the place indexed N using minimum coins.

If there are multiple paths with the same cost, return the lexicographically smallest such path.

If it's not possible to reach the place indexed N then you need to return an empty array.

Example 1:
Input: [1,2,4,-1,2], 2
Output: [1,3,5]
Example 2:
Input: [1,2,4,-1,2], 1
Output: []
Note:
Path Pa1, Pa2, ..., Pan is lexicographically smaller than Pb1, Pb2, ..., Pbm, if and only if at the first i
 where Pai and Pbi differ, Pai < Pbi; when no such i exists, then n < m.
A1 >= 0. A2, ..., AN (if exist) will in the range of [-1, 100].
Length of A is in the range of [1, 1000].
B is in the range of [1, 100].
 */

import java.util.*;
public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        LinkedList<Integer> out = new LinkedList<>();
        
        int len = A.length;
        // minimum cost at point i
        int cost[] = new int[len];
        // previous node with minimum cost
        int prev[] = new int[len];
        // jump length with minimum cost
        // only for lexicographical order
        int length[] = new int[len];
        
        // initialize the arrays, first cost is A[0], previous node is -1, length is 0
        cost[0] = A[0];
        prev[0] = -1;
        length[0] = 0;
        for (int i = 1; i < len; i++) {
            // cost -1 means not reachable
            cost[i] = -1;
            if (A[i] == -1) {
                continue;
            }
            // scan for all possibilities can jump to current node
            // from left to right -- again, for the lexicographical order
            for (int idx = Math.max(0, i - B); idx < i; idx++) {
                // skip the non-reachable
                if (cost[idx] == -1)
                    continue;
                int newCost = cost[idx] + A[i];
                if (cost[i] == -1 ||    // first solution
                        // better solution
                        newCost < cost[i] ||    
                        // same solution with small lexicographical order
                        (newCost == cost[i] && length[i] < length[idx] + 1)) {
                    // mark the new solution
                    cost[i] = newCost;
                    prev[i] = idx;
                    length[i] = length[idx] + 1;
                }
            }
        }
        
        if (cost[len-1] == -1)
            return out;
        // scan from last to first to get the linklist
        int idx = len-1;
        while (idx != -1) {
            out.addFirst(idx+1);
            idx = prev[idx];
            
        }
        
        return out;
        
    }
    
    public static void printResult(List<Integer> list) {
        for (Integer i:list) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        CoinPath c  = new CoinPath();
        int array[] = {1,2,4,-1,2};
        List<Integer> list = c.cheapestJump(array, 2);
        printResult(list);
    }
}
