package stack;
/*
 * Leetcode 682. Baseball Game
 * You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
 */
import java.util.*;
public class BaseBall {
    public int calPoints(String[] ops) {
        int sum = 0;
        if (ops == null || ops.length < 1)
            return sum;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].charAt(0) == '-' || Character.isDigit(ops[i].charAt(0))) {
                stack.push(Integer.parseInt(ops[i]));
            } else {
                switch (ops[i].charAt(0)) {
                case 'C':
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case 'D':
                    if (!stack.isEmpty())
                        stack.push(stack.peek()*2);
                    break;
                case '+':
                    if (stack.isEmpty())
                        stack.push(0);
                    else if (stack.size() == 1)
                        stack.push(stack.peek());
                    else {
                        int p1 = stack.pop();
                        int p = p1 + stack.peek();
                        stack.push(p1);
                        stack.push(p);
                    }
                    
                    break;
                    
                }
            }
        }
        
        while (!stack.isEmpty())
            sum += stack.pop();
        
        return sum;
        
    }
    
    
    public static void main(String args[]) {
        String v1[] = {"5","-2","4","C","D","9","+","+"};
        BaseBall b = new BaseBall();
        System.out.println(b.calPoints(v1));
    }
}
