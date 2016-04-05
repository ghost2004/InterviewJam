package stack;
/*
 * Leetcode 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid
 but "(]" and "([)]" are not.
 */
import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case ')':
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
                break;
            case ']':
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
                break;
            case '}':
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
                break;
            default:
                return false;
                    
            }
        }
        return stack.isEmpty();
    }
}
