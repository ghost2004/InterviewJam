package dynamicProgramming;
/*
 * 
 * Leetcode 91. Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    private boolean isValid(String t) {
        if (t.charAt(0) == '0')
            return false;
        int val = Integer.parseInt(t);
        return val >=1 && val <=26;
    }
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int ways[] = new int[s.length()+1];
        ways[0] = 1;
        ways[1] = 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i-1, i))) 
                ways[i]+=ways[i-1];
            if (isValid(s.substring(i-2, i))) 
                ways[i]+=ways[i-2];
        }
        
        return ways[s.length()];
    }

}
