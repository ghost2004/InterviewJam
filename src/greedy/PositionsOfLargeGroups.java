package greedy;
/*
 * Leetcode 830. Positions of Large Groups
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
 

Note:  1 <= S.length <= 1000
 */
import java.util.*;
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> out = new ArrayList<>();
        int max = 2;
        int lastIdx = 0;
        int cur = 1;
        while (cur < S.length()) {
            while (cur < S.length() && S.charAt(cur) == S.charAt(lastIdx))
                cur++;
            if (cur - lastIdx > max) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(lastIdx);
                item.add(cur-1);
                out.add(item);
            }

            lastIdx = cur;
        }
        
        return out;
        
    }
    
    public static void dumpList(List<List<Integer>> in) {
        for (List<Integer> item :in) {
            System.out.print("[");
            for (Integer i: item)
                System.out.print(i+",");
            System.out.print("]");
        }
    }
    
    public static void main(String args[]) {
        PositionsOfLargeGroups p  = new PositionsOfLargeGroups();
        dumpList(p.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
    
    

}
