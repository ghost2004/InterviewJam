package hashtable;
/*
 * Leetcode 5189. Maximum Number of Balloons
 * 
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only
 */
import java.util.*;
public class MaxNumBalloons {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        set.add('b');
        set.add('a');
        set.add('l');
        set.add('o');
        set.add('n');
        
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (Character s: set) {
            int cnt = map.getOrDefault(s, 0);
            if (s == 'l' || s == 'o') {
                cnt /= 2;
            }
            min = Math.min(min, cnt);
        }
        
        return min;
    }
    
}
