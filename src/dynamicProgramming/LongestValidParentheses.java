package dynamicProgramming;
/*
 * Leetcode 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is 
"()()", which has length = 4.
 */
import java.util.Stack;
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int max = 0;
        int lastIdx = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    lastIdx = i;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i-lastIdx);
                } else {
                    max = Math.max(max, i-stack.peek());
                }
                
            }
        }
        
        return max;
        
    }

}
