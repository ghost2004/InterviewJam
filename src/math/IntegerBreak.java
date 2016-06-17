package math;

import java.util.Arrays;

/*
 * Given a positive integer n, break it into the sum of at least two positive
 *  integers and maximize the product of those integers. Return the maximum 
 *  product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); 
given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.
 */
public class IntegerBreak {
	public int integerBreak(int n) {
		
		if (n <= 3)
			return n-1;
		
        int dp[] = new int[n+1];
        
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
        	for (int j = 1; j < i+1; j++) {
        		if (i + j <= n)
        			dp[i+j] = Math.max(Math.max(i, dp[i]) * Math.max(j, dp[j]), dp[i+j]);
        	}
        }
        return dp[n];
    }
}
