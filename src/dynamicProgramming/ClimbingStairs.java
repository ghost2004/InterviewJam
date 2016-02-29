package dynamicProgramming;
/*
 * Leetcode 70. Climbing Stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct 
 * ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        
        if (n <= 2) 
            return n;
        int p1 = 1;
        int p2 = 2;
        
        for (int i = 2; i < n; i++) {
            p2 += p1;
            p1 = p2 - p1;
        }
        
        return p2;
    }

}
