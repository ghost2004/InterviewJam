package math;
/*
 * Leetcode 670. Maximum Swap
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
 * Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 10^8]
 */

public class MaximumSwap {
    public int maximumSwap(int num) {
        // Convert num to char array
        // the digit[0] is the highest
        char digits[] = Integer.toString(num).toCharArray();
        
        int map[] = new int[10];
        
        // save the each number in latest position
        for (int i = 0; i < digits.length; i++) {
            map[digits[i]-'0'] = i;
        }
        
        // scan from left to right in num
        for (int i = 0 ; i < digits.length; i++) {
            // search all numbers that bigger than current number
            for (int k = 9; k > digits[i] - '0'; k--) {
                // this number is bigger and show up later
                if (map[k] > i) {
                    // here to swap 
                    char tmp = digits[i];
                    digits[i] = digits[map[k]];
                    digits[map[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        
        return num;
    }
    
    public static void main(String args[]) {
        MaximumSwap m = new MaximumSwap();
        System.out.println(m.maximumSwap(98368));
    }
}
