package stack;
/*
 * Given a string which contains only lowercase letters, remove duplicate letters so that 
 * every letter appear once and only once. You must make sure your result is the smallest
 *  in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2)
            return s;
        int cnt[] = new int[26];
        for (int i = 0; i < s.length(); i++) 
            cnt[s.charAt(i) - 'a']++;
        String out = new String();
        
        return out;
    }
}
