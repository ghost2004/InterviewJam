package Trees;
/*
 * 
 * Leetcode 648. Replace Words
 * 
 * In English, we have a concept called root, which can be followed by some other words to form
 *  another longer word - let's call this word successor. For example, the root an, followed by 
 *  other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the
 successor in the sentence with the root forming it. If a successor has many roots can form it,
  replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 */
import java.util.*;
public class ReplaceWords {
    private class TrieNode {
        String val;
        boolean isleaf;
        HashMap<Character, TrieNode> children;
        
        public TrieNode(String s) {
            val = s;
            isleaf = false;
            children = new HashMap<Character, TrieNode>();
        }
        
        public void add(String key, int idx) {
            // this is a root word
            if (idx >= key.length()) {
                isleaf = true;
                return;
            }
            
            char c = key.charAt(idx);
            TrieNode child = children.get(c);
            if (child == null) {
                String n = val + c;
                child = new TrieNode(n);
                children.put(c, child);
            }
            
            // only keep the shortest root
            if (!child.isleaf)
                child.add(key, idx+1);
        }
        
        public String search(String key, int idx) {
            if (isleaf) 
                return val;
            if (idx >= key.length())
                return key;
            char c = key.charAt(idx);
            TrieNode child = children.get(c);
            if (child == null)
                return key;
            return child.search(key, idx+1);
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode("");
        for (String s:dict) {
            root.add(s, 0);
        }
        
        String array[] = sentence.split(" ");
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            out.append(root.search(array[i], 0));
            if (i != array.length-1)
                out.append(" ");
        }
        
        return out.toString();
    }

}
