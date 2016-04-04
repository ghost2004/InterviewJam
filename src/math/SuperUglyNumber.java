package math;
/*
 * Leetcode 313. Super Ugly Number
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list 
primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence 
of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4
 */
import java.util.*;
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Long ugly = new Long(1);
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        int i, j, k;
        for (i = 0; i < primes.length; i++) {
            pq.offer(new Long(primes[i]));
        }
        
        for (i = 1; i < n; i++) {
            ugly = pq.poll();
            for (j = 0; j < primes.length; j++) {
                if (ugly % primes[j] == 0) {
                    for (k = 0; k <= j; k++) {
                        pq.offer(ugly*primes[k]);
                    }
                    break;
                }
            }
        }
        
        return ugly.intValue();
    }
}
