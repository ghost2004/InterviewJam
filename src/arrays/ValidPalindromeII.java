package arrays;
/*
 * 
 * Leetcode 680. Valid Palindrome II
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    
    private boolean checkP(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int left = 0;
        int right = s.length()-1;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return (checkP(s.substring(left, right)) || checkP(s.substring(left+1, right+1)));
        }
        
        return true;
    }

}
