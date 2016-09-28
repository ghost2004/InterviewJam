package bit;
/*
 * Leetcode 318. Maximum Product of Word Lengths
 * 
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where 
 * the two words do not share common letters. You may assume that each word will contain only lower
 *  case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
public class MaxProductWordLength {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2)
            return 0;
        int i,j;
        int max = 0;
        int map[] = new int[words.length];
        for (i = 0; i < words.length; i++) {
            map[i] = 0;
            for (j = 0; j < words[i].length(); j++) {
                map[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        for (i = 0; i < words.length-1; i++) {
            for (j = i+1; j <words.length; j++) {
                if ( (map[i]&map[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}
