package dynamicProgramming;
/*
 * Imagine you have a special keyboard with the following keys:

Key 1: (A): Prints one 'A' on screen.

Key 2: (Ctrl-A): Select the whole screen.

Key 3: (Ctrl-C): Copy selection to buffer.

Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the
 maximum numbers of 'A' you can print on screen.

Example 1:
Input: N = 3
Output: 3
Explanation: 
We can at most get 3 A's on screen by pressing following key sequence:
A, A, A
Example 2:
Input: N = 7
Output: 9
Explanation: 
We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
Note:
1 <= N <= 50
Answers will be in the range of 32-bit signed integer.
 */
public class FourKeyPad {
    
    public int maxA(int N) {
        // the first 6 is always its self
        if (N <= 6)
            return N;
        int dp[] = new int[N+1];
        for (int i = 0; i <= 6; i++)
            dp[i] = i;
        
        for (int i = 7; i <= N; i ++) {
            dp[i] = i;
            for (int j = 3; j < i; j++) {
                // for example, when N = 7 the max will be one of this
                // step4 * 2 AAAA Ctrl A Ctrl C Ctrl V 
                // step3 * 3 AAA Ctrl A Ctrl C Ctrl V Ctrl V 
                // step2 * 4 AA Ctrl A Ctrl C Ctrl V Ctrl V Ctrl V
                // step1 * 5 A Ctrl A Ctrl C Ctrl V Ctrl V Ctrl V Ctrl V
                dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
            }
        }
        
        return dp[N];
    }


}
