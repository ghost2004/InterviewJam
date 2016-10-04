package hashtable;
/*
 * Leetcode 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter 
in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase
 letters separated by a single space.
 */
import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        // Map from a -> dog
        HashMap<Character,String> keyMap = new HashMap<Character,String>();
        // Map from dog -> a
        HashMap<String, Character> valMap = new HashMap<String, Character>();
        int idx = 0;
        String s[] = str.split(" ");
        if (pattern.length() != s.length)
            return false;
        for (idx = 0; idx < s.length; idx++) {
            Character c = pattern.charAt(idx);
            // pattern to string check
            String val = keyMap.get(c);
            if (val == null) {
                keyMap.put(c, s[idx]);
            } else {
                if (!val.equals(s[idx]))
                    return false;
            }
            // string to pattern check
            c = valMap.get(s[idx]);
            if (c == null) {
                valMap.put(s[idx], pattern.charAt(idx));
            } else {
                if (c != pattern.charAt(idx))
                    return false;
            }
        }
        
        return true;
    }
}
