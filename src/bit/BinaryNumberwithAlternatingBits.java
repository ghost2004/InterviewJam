package bit;
/*
 * Leetcode 693 Binary Number with Alternating Bits
 * Given a positive integer, check whether it has alternating bits or not.

    Example 1:
    Input: 5
    Output: True
    Explanation:
    The binary representation of 5 is: 101
    Example 2:
    Input: 7
    Output: False
    Explanation:
    The binary representation of 7 is: 111
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int t = n & 1;
        n >>= 1;
        while (n > 0) {
            int p = n & 1;
            if (p == t)
                return false;
            t = p;
            n >>= 1;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        BinaryNumberwithAlternatingBits b = new BinaryNumberwithAlternatingBits();
        System.out.println(b.hasAlternatingBits(5));
    }
}
