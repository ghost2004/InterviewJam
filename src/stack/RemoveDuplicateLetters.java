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
import java.util.*;
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2)
            return s;
        int cnt[] = new int[26];
        for (int i = 0; i < s.length(); i++) 
            cnt[s.charAt(i) - 'a']++;

        boolean visited[] = new boolean[26];
        
        Stack<Character> q = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            cnt[index]--;
            if (visited[index])
                continue;
            while (!q.isEmpty() && q.peek() > c && cnt[q.peek()-'a']>0) {
                visited[q.pop()-'a'] = false;
            }
            q.push(c);
            visited[index]=true;
            
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pop());
        }

        return sb.reverse().toString();

    }
}
