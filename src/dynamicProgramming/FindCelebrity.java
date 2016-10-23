package dynamicProgramming;

import java.util.Arrays;

/*
 * Leecode  277 Find the Celebrity 
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 *  The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one.
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to
get information of whether A knows B. You need to find out the celebrity (or verify there is not one)
 by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B.
Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there 
is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindCelebrity {
    private int[][] matrix;
    public FindCelebrity(int[][] m) {
        matrix = m;
    }
    public boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }
    
    public int findCelebrity(int n) {
        boolean candidate[] = new boolean[n];
        Arrays.fill(candidate, true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && candidate[i]; j++) {
                if (i != j) {
                    if (knows(i, j)) 
                       candidate[i] = false; 
                    if (!knows(j ,i))
                       candidate[i] = false;
                    else
                       candidate[j] = false;
                }
            }
            if (candidate[i]) return i;

        }

        return -1;
    }
    
    public int findCelebrity2(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++)
            if (knows(candidate, i))
                candidate = i;
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows(candidate, i) || !knows(i, candidate))
                    return -1;
            }
        }
        return candidate;
    }

}
