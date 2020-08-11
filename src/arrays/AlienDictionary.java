package arrays;
/*
 * Leetcode 953. Verifying an Alien Dictionary
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is 
 * some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted
 lexicographicaly in this alien language.
 */
public class AlienDictionary {
    private boolean isLess(String a, String b, int[] dict) {
        
        int bound = Math.min(a.length(), b.length());
        for (int i = 0; i < bound; i++) {
            int leftIdx = dict[a.charAt(i) - 'a'];
            int rightIdx = dict[b.charAt(i) - 'a'];
            if (leftIdx < rightIdx)
                return true;
            else if (leftIdx > rightIdx)
                return false;
        }
        
        return a.length() < b.length();
    }
    
    public boolean isAlienSorted(String[] words, String order) {
    
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!isLess(words[i], words[i+1], dict))
                return false;
        }
        
        return true;
    }

}
