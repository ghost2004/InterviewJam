package arrays;
/*
 * Leetcode 459. Repeated Substring Pattern
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of 
 * the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatSubstr {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2)
            return false;
        int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            if (len % i != 0)
                continue;
            int chunk = len / i;
            String pattern = s.substring(0, i);

            boolean match = true;
            for (int j = 1; j < chunk; j++) {
                if (!s.substring(i * j, i * j + i).equals(pattern)) {
                    match = false;
                    break;
                }
            }
            if (match)
                return true;
        }

        return false;
    }
}
