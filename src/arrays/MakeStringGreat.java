package arrays;
/*
 * Leetcode 5483. Make The String Great
 * Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

 

Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "x"
Output: "s"
 */
public class MakeStringGreat {
    public static String makeGood(String s) {
        if (s.length() < 2)
            return s;
        boolean flag = false;
        String t = new String(s);
        do {
            flag = false;
            StringBuffer buf = new StringBuffer();
            int i = 0;
            for (; i < t.length()-1; i++) {

               String t1 = t.substring(i,  i+1);
               String t2 = t.substring(i+1,  i+2);
               if ((!t1.equals(t2) && t1.equalsIgnoreCase(t2)))  {
                   flag = true;
                   i = i+1;
               } else {
                   buf.append(t1);
                   
               }
            }
            if (i == t.length() -1) 
                buf.append(t.charAt(i));  
            
            
            t = buf.toString();

        } while (flag); 
        
        return t;

    }
    
    public static void main(String args[]) {
        
        String test[] = {"leEeetcode", "abBAcC", "s", "qFxXfQo"};
        String testE[] = {
                
        };
        for (String s:test) {
            System.out.println(s +" -> " + makeGood(s));
        }
    }

}
