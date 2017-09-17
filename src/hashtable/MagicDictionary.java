package hashtable;
/*
 * Leetcode 676. Implement Magic Dictionary
 * Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character 
into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient 
algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class 
variables are persisted across multiple test cases. Please see here for more details.
 */
import java.util.*;
public class MagicDictionary {
    private HashMap<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (int i = 0; i < dict.length; i++) {
            Integer key = dict[i].length();
            ArrayList<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(dict[i]);
                map.put(key, list);
            } else{
                list.add(dict[i]);
            }
        }
    }
    
    private boolean isMatched(String pattern, String word) {
        int len = pattern.length();
        int mis = 0;
        
        for (int i = 0; i < len; i++) {
            if (pattern.charAt(i) != word.charAt(i)) {
                mis++;
                if (mis > 1)
                    return false;
            }
        }
        
        return mis == 1;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null)
            return false;
        ArrayList<String> list = map.get(word.length());
        
        if (list == null)
            return false;
        
        for (String s:list) {
            if (isMatched(s, word))
                return true;
        }
        
        
        return false;
    }
}
