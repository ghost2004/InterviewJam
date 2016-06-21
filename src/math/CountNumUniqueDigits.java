package math;
/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ¡Ü x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ¡Ü x < 100, 
excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int base = Math.min(10, n);
        int dp[] = new int[base+1];
        dp[0] = 1;
        
        for (int i = 1; i <= base; i++) {
            dp[i] = 9;
            for (int j = 9; j > 10 - i; j--) {
                dp[i] *= j;
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++ )
            res += dp[i];
        
        return res;
        
    }
}
