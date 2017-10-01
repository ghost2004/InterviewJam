package arrays;
/*
 * Leetcode 686. Repeated String Match
 * Given two strings A and B, find the minimum number of times A has to be repeated 
 * such that B is a substring of it. If no such solution, return -1.

    For example, with A = "abcd" and B = "cdabcdab".
    
    Return 3, because by repeating A three times (¡°abcdabcdabcd¡±), B is a substring of it; 
    and B is not a substring of A repeated two times ("abcdabcd").
    
    Note:
    The length of A and B will be between 1 and 10000.
 */
public class RepeatedStrMatch {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() < 1)
            return -1;
        if (B == null || B.length() < 1)
            return 1;
        int lenA = A.length();
        int lenB = B.length();
        
        String buf = A;
        
        for (int i = 0; i <= lenB/lenA+1; i++) {
            if (buf.indexOf(B) != -1)
                return i+1;
            buf += A;
        }
            
        return -1;
    }
}
