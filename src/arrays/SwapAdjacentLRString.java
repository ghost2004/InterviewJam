package arrays;
/*
 * Leetcode 777. Swap Adjacent in LR String
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either 
 * replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given 
 * the starting string start and the ending string end, return True if and only if there exists a 
 * sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class SwapAdjacentLRString {
    public static boolean canTransform(String start, String end) {
        if (start == null && end == null) 
            return true;
        if (start == null || end == null)
            return false;
        if (start.length() != end.length())
            return false;
        
        int numL = 0;
        int numR = 0;
        
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L')
                numL++;
            else if (start.charAt(i) == 'R')
                numR++;
            if (end.charAt(i) == 'L')
                numL--;
            else if (end.charAt(i) == 'R')
                numR--;
            if ( numL > 0 // start string has L now but end string does not have L yet, L can't move to the right 
                || numR < 0 // end string has R now but start string does not have R yet, R can'move to the left
                || (numR * numL != 0) // L and R can't be non-zero at the same time, they can't switch side
                    )
                return false;
            
        }
        return numL == 0 && numR == 0;
    }
    
    
    public static void main(String args[]) {
        System.out.println(canTransform("LX", "XL"));
        System.out.println(canTransform("RXL", "LXR"));
    }

}
