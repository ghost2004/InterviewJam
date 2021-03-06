package dynamicProgramming;
/*
 * Leetcode 264. Ugly Number II
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 */
import java.util.*;
public class UglyNumberII {
    /*dynamic programming solution*/
    public int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        // index for 2 , 3, 5
        int idx[] = {0, 0, 0};
        int base[] = {2, 3, 5};
        for (int i = 1; i < n; i++) {
            int pt = 0;
            for (int j = 1; j < 3;j++)  
                if (base[j] * ugly[idx[j]] < base[pt] * ugly[idx[pt]])
                    pt = j;
            
            ugly[i] = base[pt] * ugly[idx[pt]];
            // skip the duplicate number
            if (ugly[i] == ugly[i-1])
                i--;
            idx[pt]++;
        }
        return ugly[n-1];
    }
    
    /* min heap solution */
    public int nthUglyNumberHeap(int n) {
        Long ugly = new Long(1);
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.offer(new Long(2));
        pq.offer(new Long(3));
        pq.offer(new Long(5));
        for (int i = 1; i < n; i++) {
            ugly = pq.poll();
            if (ugly % 2 == 0) {
                pq.offer(ugly*2);
            } else if (ugly % 3 == 0) {
                pq.offer(ugly*2);
                pq.offer(ugly*3);
            } else if (ugly % 5 == 0) {
                pq.offer(ugly*2);
                pq.offer(ugly*3);
                pq.offer(ugly*5);
            }
        }
        return ugly.intValue();
    }
    public static void main(String args[]) {
        UglyNumberII u = new UglyNumberII();
        //for (int i = 1; i <= 10; i++)
        System.out.println(u.nthUglyNumber(7));
    }
}
