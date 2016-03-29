package math;
/*
 * Leetcode 263. Ugly Number
 * 
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int u = num;
        while ( u > 5 ) {
            if ( u % 2 == 0) {
                u /= 2;
            } else if (u % 3 == 0) {
                u /= 3;
            } else if (u % 5 == 0) {
                u /= 5;
            } else
                return false;
        }
        return true;
    }

}
