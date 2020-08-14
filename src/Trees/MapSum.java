package Trees;
/*
 * Leetcode 677. Map Sum Pairs 
 * 
 * Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer 
represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the 
pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */

import java.util.*;


public class MapSum {
    
    class TrieNode {
        HashMap<Character, TrieNode> children;
        int value;
        // Initialize your data structure here.
        public TrieNode() {
            this.children = new HashMap<>();
            this.value = 0;
        }
    }
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    
    public void insert(String key, int val) {
        if (key == null || key.length() == 0)
            return;
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        
        cur.value = val;
        
    }
    

    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode next = cur.children.get(c);
            if (next == null) {
                return 0;
            }
            cur = next;
        }
        return dfs(cur);
    }
    
    private int dfs(TrieNode node) {
        int sum = 0;
        
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sum += dfs(entry.getValue());
        }
        
        return sum + node.value;
    }
    
    public static void main(String args[]) {
        
        MapSum m = new MapSum();
        
        m.insert("a", 3);
        System.out.println(m.sum("ap"));
        m.insert("b", 2);
        System.out.println(m.sum("a"));
        
        m = new MapSum();
        m.insert("aa", 3);
        System.out.println(m.sum("aa"));
        m.insert("aa", 2);
        System.out.println(m.sum("aa"));
        
        m = new MapSum();
        m.insert("apple", 3);
        System.out.println(m.sum("apple"));
        m.insert("app", 2);
        System.out.println(m.sum("ap"));
    }
}
