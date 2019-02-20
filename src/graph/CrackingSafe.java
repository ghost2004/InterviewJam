package graph;
/*
 * Leetcode 753. Cracking the Safe
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.

You can keep inputting the password, the password will automatically be matched against the last n digits entered.

For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

Please return any string of minimum length that is guaranteed to open the box after the entire string is inputed.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.
 */
import java.util.*;
public class CrackingSafe {
    class CrackPassword {
        private int n;
        private int k;
        private StringBuilder sb;
        private HashSet<String> visited;
        private int total; 
        
        public CrackPassword(int N, int K) {
            n = N;
            k = K;
            total = (int)Math.pow(k, n);
            visited = new HashSet<>();
            sb = new StringBuilder();
        }
        
        private boolean dfs() {
            if (visited.size() == total)
                return true;
            String prev = sb.substring(sb.length() - n + 1, sb.length());
            for (Integer i = 0; i < k; i++) {
                String next = prev + i.toString();
                if (!visited.contains(next)) {
                    visited.add(next);
                    sb.append(i);
                    if (dfs()) return true;
                    visited.remove(next);
                    sb.deleteCharAt(sb.length()-1);
                }
                
            }
            return false;
        }
        
        public String getCrackCode() {
            // start with all '0' code
            for (int i = 0; i < n; i++)
                sb.append('0');
            visited.add(sb.toString());
            dfs(); 
            return sb.toString();
        }
        
    }
    
    public String crackSafe(int n, int k) {
        CrackPassword c = new CrackPassword(n , k);
        return c.getCrackCode();
    }
    
    private boolean dfs(StringBuilder builder, HashSet<String> visited, int total, int n, int k) {
        // visited all possible combinations, this is the solution
        if (visited.size() == total)
            return true;
        // pick up the last n-1 characters from the buffer
        String prev = builder.substring(builder.length() - n + 1, builder.length());
        // search for the next string
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            // skip it if visited before
            if (!visited.contains(next)) {
                // mark this node as visited
                visited.add(next);
                // add current character to the buffer
                builder.append(i);
                // return true if found possible solution
                if (dfs(builder, visited, total, n, k))
                    return true;
                visited.remove(next);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        
        return false;
    }
    public String crackSafe2(int n, int k) {
        StringBuilder builder = new StringBuilder();
        // total possible combination of password is k^n
        int total = (int)Math.pow(k, n);
        // visited node set is empty at the beginning
        HashSet<String> visited = new HashSet<>();
        // start with all '0' password
        for (int i = 0; i < n; i++)
            builder.append('0');
        visited.add(builder.toString());
        dfs(builder, visited, total, n, k);
        return builder.toString();
    }

}
