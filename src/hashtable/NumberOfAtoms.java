package hashtable;
/*
 * LeetCode 726. Number of Atoms
 * 
 * Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no 
digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed 
by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count 
is more than 1), and so on.

    Example 1:
    Input: 
    formula = "H2O"
    Output: "H2O"
    Explanation: 
    The count of elements are {'H': 2, 'O': 1}.
    Example 2:
    Input: 
    formula = "Mg(OH)2"
    Output: "H2MgO2"
    Explanation: 
    The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
    Example 3:
    Input: 
    formula = "K4(ON(SO3)2)2"
    Output: "K4N2O14S4"
    Explanation: 
    The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
    Note:
    
    All atom names consist of lowercase letters, except for the first character which is uppercase.
    The length of formula will be in the range [1, 1000].
    formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
 */
import java.util.*;
public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        // atoms need to be sorted in out layer
        Map<String, Integer> map = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        int length = formula.length();
        int idx = 0;
        while (idx < length) {
            char c=formula.charAt(idx++);
            switch (c) {
            case '(':
                stack.push(map);
                // atoms don't need to be sorted in inner layer
                map = new HashMap<>();
                break;
            case ')':
                int val = 0;
                while (idx < length && Character.isDigit(formula.charAt(idx))) {
                    val = val * 10 +  formula.charAt(idx++) - '0';
                }
                Map<String, Integer> curMap = map;
                map = stack.pop();
                for (Map.Entry<String, Integer> entry : curMap.entrySet()) {
                    Integer cnt = map.getOrDefault(entry.getKey(), 0);
                    map.put(entry.getKey(), entry.getValue() * val + cnt);
                }
                break;
            default:
                int startIdx = idx - 1;
                while (idx < length && Character.isLowerCase(formula.charAt(idx))) {
                    idx++;
                }
                String atom = formula.substring(startIdx, idx);
                int count = 0;
                while (idx < length && Character.isDigit(formula.charAt(idx))) {
                    count = count * 10 +  formula.charAt(idx++) - '0';
                }
                count = count == 0 ? 1 : count;
                count += map.getOrDefault(atom, 0);
                map.put(atom, count);
            }
        }
        
        StringBuffer buf = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            buf.append(entry.getKey());
            if (entry.getValue() > 1)
                buf.append(entry.getValue());
        }
        
        return buf.toString();
        
    }
    
    public static void main(String args[]) {
        NumberOfAtoms n = new NumberOfAtoms();
        System.out.println(n.countOfAtoms("H2O"));
        System.out.println(n.countOfAtoms("Mg(OH)2"));
    }
}
