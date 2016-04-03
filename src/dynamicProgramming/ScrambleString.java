package dynamicProgramming;

import java.util.Arrays;

/*
 * Leetcode 87. Scramble String
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
    // recursive solution 
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        char t1[] = s1.toCharArray();
        char t2[] = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        if (!new String(t1).equals(new String(t2)))
            return false;
        for (int split = 1; split < s1.length();split++) {
            String s11 = s1.substring(0, split);
            String s12 = s1.substring(split);
            
            String s21 = s2.substring(0, split);
            String s22 = s2.substring(split);
            
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            
            s21 = s2.substring(0, s2.length()-split);
            s22 = s2.substring(s2.length()-split);
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }
        return false;
    }
    
    // dynamic programming solution
    public boolean isScrambleDP(String s1, String s2) {
        int length = s1.length();
        if (length != s2.length())
            return false;
        // dp[i][j][k] means s1 substring starts at i, s2 substring starts at j with length k+1 is ScrambleString
        boolean dp[][][] = new boolean[length][length][length];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        
        for (int len = 2;len <= length; len++) {
            for (int i = length - len; i >= 0; i--) {
                for (int j = length - len; j >= 0; j--) {
                    boolean flag = false;
                    for (int k = 1; k<= len; k++) {
                        flag = (dp[i][j][k-1] && dp[i+k][j+k][len-k-1]) || (dp[i][j+len-k][k-1]&&dp[i+k][j][len-k-1]); 
                        if (flag)
                            break;
                    }
                    dp[i][j][len-1] = flag;
                }
            }
        }
        return dp[0][0][length-1];
    }

}
