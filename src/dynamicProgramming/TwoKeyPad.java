package dynamicProgramming;
/*
 * 
 * Leetcode 650. 2 Keys Keyboard
 * 
 * Initially on a notepad only one character 'A' is present. You can perform two operations on 
 * this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number 
of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Note:
The n will be in the range [1, 1000].
 */
import java.util.*;
public class TwoKeyPad {
    public int minSteps(int n) {
        if (n < 2) 
            return 0;
        if (n == 2)
            return 2;
        
        LinkedList<Integer> primes = new LinkedList<Integer>();
        
        int k =2;
        int N = n;
        
        
        
        while (k <= N) {
            if (N % k == 0) {
                primes.addFirst(k);
                N = N/k;
            } else
                k++;
        }
        
        int cnt = primes.poll();
        
        while (!primes.isEmpty()) {
            cnt += primes.poll();
        }

        
        return cnt;
    }
    
    public int minSteps2(int n) {
        int cnt = 0;
        int N = n;
        int k = 2;
        
        while (N >= k) {
            if (N % k == 0) {
                cnt += k;
                N /= k;
            } else
                k++;
        }
        
        return cnt;
        
    }
    
    
    public static void main(String args[]) {
        TwoKeyPad t = new TwoKeyPad();
        
        for (int i = 2; i < 13; i++)
            System.out.println("input :" + i+ " output:" +t.minSteps(i));

    }
    

}
