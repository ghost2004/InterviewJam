package dynamicProgramming;
/*
 * Leetcode 161 One Edit Distance
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if (Math.abs(sLen - tLen) > 1)
            return false;
        
        int sIdx = 0;
        int tIdx = 0;
        int mismatch = 0;
        while (sIdx < sLen && tIdx < tLen) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                tIdx++;
            } else {
                mismatch++;
                if (mismatch > 1)
                    return false;
                if (sLen == tLen) {
                    sIdx++;
                    tIdx++;
                } else if (sLen < tLen) {
                    tIdx++;
                } else {
                    sIdx++;
                }
            }
        }
        
        if (sIdx < sLen || tIdx < tLen) 
            mismatch++;
        return mismatch <= 1;
    }
}
