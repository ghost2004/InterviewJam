package math;
/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 <= x < 100, 
excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        // totally 0 ~ 9,  10 numbers
        int base = Math.min(10, n);
        // dp[i] means the number of choice when digital length is i
        int dp[] = new int[base+1];
        // digital length is 0, only one choice, which is 0
        dp[0] = 1;
        
        for (int i = 1; i <= base; i++) {
            // choice for the first number is 9 , which is from 1 ~ 9
            dp[i] = 9;
            for (int j = 9; j > 10 - i; j--) {
                // choice for next number is 9, which is 0~9 except the first number
                // choice for third number is 8 ... etc
                dp[i] *= j;
            }
        }
        // sum of all possible digital length
        int res = 0;
        for (int i = 0; i <= n; i++ )
            res += dp[i];
        
        return res;
        
    }
}
