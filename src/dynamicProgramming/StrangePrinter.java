package dynamicProgramming;
/*
 * Leetcode 664. Strange Printer
 * There is a strange printer with the following two special requirements:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, 
and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum 
number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, 
which will cover the existing character 'a'.
Hint: Length of the given string will not exceed 100.
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        // dp[i][j] stands for the minimum steps need to print s(i,j)
        int dp[][] = new int[len][len];
        

        
        // left bound, scan from right to left 
        for (int leftIdx = len - 1; leftIdx >= 0;leftIdx--) {
            // right bound, scan from left bound to right
            for (int rightIdx = leftIdx; rightIdx < len; rightIdx++) {
                if (leftIdx == rightIdx)
                    // all dp[i][i] should be 1 -- only one character
                    dp[leftIdx][rightIdx] = 1;
                else
                    // by default, the minimum steps are plus one by right substring
                    dp[leftIdx][rightIdx] = dp[leftIdx+1][rightIdx] + 1;
                // scan inside the substring
                for (int k = leftIdx+1; k <= rightIdx; k++) {
                    //dp[i][j] = min(dp[i][j], dp[start][k]+dp[k][end]), for each k where s[k] == s[i]
                    //Here start is first character not of s[i], and end is after last character not of s[i] 
                    if (s.charAt(k) == s.charAt(leftIdx)) 
                        dp[leftIdx][rightIdx] = Math.min(dp[leftIdx][rightIdx], 
                                dp[leftIdx+1][k-1]+dp[k][rightIdx]) ;
                    
                }
                
            }
            
        }
        
        return dp[0][len-1];
        
    }
}
