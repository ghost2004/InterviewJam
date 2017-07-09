package math;
/*
 * Solve the Equation

Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, 
the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"
 */
import java.util.*;
public class SolveEquation {
    public String solveEquation(String equation) {
        long X[] = new long[2];
        long Val[] = new long[2];
        int idx = 0;
        StringBuffer buf = new  StringBuffer();
        int signal = 1;
        try {
            for (int i = 0 ; i < equation.length(); i++) {
                char c = equation.charAt(i);
                if (Character.isDigit(c)) {
                    buf.append(c);
                } else if (c == '=') {
                    if (buf.length() != 0) 
                        Val[idx] += signal*(Long.parseLong(buf.toString()));
                    buf = new  StringBuffer();
                    signal = 1;
                    idx=1;
                    
                } else if (c == 'x') {
                    if (buf.length() == 0) 
                        X[idx]+=signal;
                    else
                        X[idx]+=signal*(Long.parseLong(buf.toString()));
                    buf = new  StringBuffer();
                } else if (c == '+') {
                    
                    if (buf.length() != 0) 
                        Val[idx] += signal*(Long.parseLong(buf.toString()));
                    signal = 1;
                    buf = new  StringBuffer();
                } else if (c == '-') {
                    
                    if (buf.length() != 0) 
                        Val[idx] += signal*(Long.parseLong(buf.toString()));
                    signal = -1;
                    buf = new  StringBuffer();
                }
                
                System.out.println("index "+ i + " Char "+ c +" signal "+ signal+ " Val: "+Val[0]+ " "+ Val[1]+ " x: "+ X[0]+" " + X[1]);
            }
            
            if (buf.length() != 0) 
                Val[idx] += signal*(Long.parseLong(buf.toString()));
        } catch (Exception e) {
            return new String("No solution");
        }
        

        
        if (X[0] == X[1] && Val[0] == Val[1])
            return new String("Infinite solutions");
        
        if (X[0] == X[1] && Val[0] != Val[1])
            return new String("No solution");
        System.out.println("Val: "+Val[0]+ " "+ Val[1]+ " x: "+ X[0]+" " + X[1]);
        buf = new  StringBuffer();
        buf.append("x=");
        buf.append((Val[1]-Val[0])/(X[0]-X[1]));
        return buf.toString();
    }
    
    public static void main(String args[]) {
        SolveEquation se = new SolveEquation();
        System.out.println(se.solveEquation("2=-x"));
        /*
        System.out.println(se.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(se.solveEquation("x=x"));
        System.out.println(se.solveEquation("2x=x"));
        System.out.println(se.solveEquation("2x+3x-6x=x+2"));
        System.out.println(se.solveEquation("x=x+2"));
        System.out.println(se.solveEquation("1+1=x"));
        */
    }
}
