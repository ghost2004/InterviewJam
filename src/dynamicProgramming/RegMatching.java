package dynamicProgramming;
/*
 * Leetcode 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
 */
public class RegMatching {
    public boolean isMatch(String s, String p) {
        // reach the end of pattern, if string also reaches end, then it matches
        if (p.length() == 0)
            return s.length()==0;
        // the last character in pattern 
        if (p.length() == 1) {
            // return true when
            // 1. last character matches
            // 2. last character in pattern is '.'
            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return true;
            return false;
        }
        // when the next character in pattern is '*'
        if (p.charAt(1) == '*') {
            // case 1: return true when match zero preceding element
            if (isMatch(s, p.substring(2)))
                return true;
            // case 2: return true when 
            // 1. not reach the end of string
            // 2. current character matches
            // 3. rest of string still matches current pattern
            
            return (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) =='.') && isMatch(s.substring(1), p));
        }
        
        // the rest of cases, return true when 
        // 1. not reach the end of string
        // 2. current character matches
        // 3. rest of character matches
        return (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) =='.') && isMatch(s.substring(1), p.substring(1)));
    }
    
    public boolean isMatchDP(String s, String p) {
        int sLen = s.length();
        
        
    }
    
}
