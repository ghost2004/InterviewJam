package math;
/*
 * Leetcode 633 Sum of Square Numbers
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such 
 * that a^2 + b^2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */

public class SumSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int sq =(int) Math.sqrt(c);

        for (int i = 0; i <= sq; i++) {
            int remainder = c - i*i;
            int t = (int)Math.sqrt(remainder);
            if (t*t == remainder)
                return true;

        }
        return false;
    }
}
