package dynamicProgramming;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the 
numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 10^9 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 10^5].
The input string will only contain the character '*' and digits '0' - '9'.
 */
public class DecodeWaysII {
    // decode ways in single digit
    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }
    
    // decode ways in double digit
    private int ways(char c1, char c2) {
        
        if (c1 != '*' &&  c2 != '*') {
            // case 1: no stars
            String c = ""+c1+c2;
            int val = Integer.parseInt(c);
            if (val >= 10 && val <= 26)
                return 1;
            
        } else if (c1 == '*' &&  c2 == '*') {
            // case 2: 2 stars
            return 15;
        } else if (c1 == '*') {
            // case 3: first digit is star
            if (c2 >= '0' && c2 <= '6')
                return 2;
            return 1;
        } else {
            // case 4: second digit is star
            if (c1 == '1')
                return 9;
            if (c1 == '2')
                return 6;
        }
        
        
        return 0;
    }
    public int numDecodings(String s) {
    
        long res[] = new long[2];
        res[0] = ways(s.charAt(0));
        if (s.length() < 2)
            return (int)res[0];
        res[1] = res[0]*ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        
        for(int i = 2; i < s.length(); i++){
            long temp = res[1];
            res[1] = (res[1]* ways(s.charAt(i))+ res[0]*ways(s.charAt(i-1),s.charAt(i))) %1000000007;
            res[0] = temp;
        }
        
        return (int)res[1];
    }
}
