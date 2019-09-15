package stack;
/*
 * 
 * Leetcode 5190. Reverse Substrings Between Each Pair of Parentheses
 * Given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any bracket.

 

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 */
import java.util.*;
public class ReverseInParentheses {
    public String reverseParentheses(String s) {
        
        List<List<Character>> stackList = new ArrayList();
        List<Character> list = new ArrayList<>();
        stackList.add(list);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                list = new ArrayList<>();
                stackList.add(list);
            } else if (c == ')') {
                List<Character> list2 = stackList.remove(stackList.size()-1);
                list = stackList.get(stackList.size()-1);
                for (int j = list2.size()-1; j >= 0;j--) {
                    list.add(list2.get(j));
                }
            } else {
                list.add(c);
            }
            
            
        }
        
        
        StringBuffer buf = new StringBuffer();
        list = stackList.get(0);
        for (int i = 0; i < list.size(); i++) {
            buf.append(list.get(i));
        }
        
        return buf.toString();
    }

}
