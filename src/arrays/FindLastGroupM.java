package arrays;
/*
 * Leetcode 1562 Find Latest Group of Size M
 * 
 * Given an array arr that represents a permutation of numbers from 1 to n. You have a binary string of size n that initially has all its bits set to zero.

At each step i (assuming both the binary string and arr are 1-indexed) from 1 to n, the bit at position arr[i] is set to 1. You are given an integer m and you need to find the latest step at which there exists a group of ones of length m. A group of ones is a contiguous substring of 1s such that it cannot be extended in either direction.

Return the latest step at which there exists a group of ones of length exactly m. If no such group exists, return -1.

 

Example 1:

Input: arr = [3,5,1,2,4], m = 1
Output: 4
Explanation:
Step 1: "00100", groups: ["1"]
Step 2: "00101", groups: ["1", "1"]
Step 3: "10101", groups: ["1", "1", "1"]
Step 4: "11101", groups: ["111", "1"]
Step 5: "11111", groups: ["11111"]
The latest step at which there exists a group of size 1 is step 4.
Example 2:

Input: arr = [3,1,5,4,2], m = 2
Output: -1
Explanation:
Step 1: "00100", groups: ["1"]
Step 2: "10100", groups: ["1", "1"]
Step 3: "10101", groups: ["1", "1", "1"]
Step 4: "10111", groups: ["1", "111"]
Step 5: "11111", groups: ["11111"]
No group of size 2 exists during any step.
Example 3:

Input: arr = [1], m = 1
Output: 1
Example 4:

Input: arr = [2,1], m = 2
Output: 2
 

Constraints:

n == arr.length
1 <= n <= 10^5
1 <= arr[i] <= n
All integers in arr are distinct.
1 <= m <= arr.lengthGiven an array arr that represents a permutation of numbers from 1 to n. You have a binary string of size n that initially has all its bits set to zero.

At each step i (assuming both the binary string and arr are 1-indexed) from 1 to n, the bit at position arr[i] is set to 1. You are given an integer m and you need to find the latest step at which there exists a group of ones of length m. A group of ones is a contiguous substring of 1s such that it cannot be extended in either direction.

Return the latest step at which there exists a group of ones of length exactly m. If no such group exists, return -1.

 

Example 1:

Input: arr = [3,5,1,2,4], m = 1
Output: 4
Explanation:
Step 1: "00100", groups: ["1"]
Step 2: "00101", groups: ["1", "1"]
Step 3: "10101", groups: ["1", "1", "1"]
Step 4: "11101", groups: ["111", "1"]
Step 5: "11111", groups: ["11111"]
The latest step at which there exists a group of size 1 is step 4.
Example 2:

Input: arr = [3,1,5,4,2], m = 2
Output: -1
Explanation:
Step 1: "00100", groups: ["1"]
Step 2: "10100", groups: ["1", "1"]
Step 3: "10101", groups: ["1", "1", "1"]
Step 4: "10111", groups: ["1", "111"]
Step 5: "11111", groups: ["11111"]
No group of size 2 exists during any step.
Example 3:

Input: arr = [1], m = 1
Output: 1
Example 4:

Input: arr = [2,1], m = 2
Output: 2
 

Constraints:

n == arr.length
1 <= n <= 10^5
1 <= arr[i] <= n
All integers in arr are distinct.
1 <= m <= arr.length
 */
public class FindLastGroupM {
    private boolean findLength(int bits[], int len) {
        int curLen = 0;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == 1) {
                curLen++;
            } else {
                if (curLen == len)
                    return true;
                curLen = 0;
            }
        }
        
        return curLen == len;
    }
    
    public int findLatestStep2(int[] arr, int m) {
        int last = -1;
        int bits[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            bits[arr[i]] = 1;
            if (findLength(bits, m))
                last = i;
        }
        return last < 0 ? last : last+1;
    }
    
    public int findLatestStep(int[] arr, int m) {
        int last = -1;
        int len = arr.length;
        // the length of 1 at idx i
        int length[] = new int[len + 2];
        // the number of subarry with length m 
        int count[] = new int[len + 1];
        
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i];
            // length of left neighbor 
            int left = length[idx - 1];
            // length of right neighbor 
            int right = length[idx + 1];
            // current length is its neighbors' length plus 1
            length[idx] = left + right + 1;
            // update the left bound
            length[idx - left] = length[idx];
            // update the right bound
            length[idx + right] = length[idx];
            
            // neighbors' length no longer exist
            count[left]--;
            count[right]--;
            // add current length
            count[length[idx]]++;
            if (count[m] > 0)
                last = i;

        }
        return last < 0 ? last : last+1;
    }
    
    
    
    
    public static void main(String args[]) {
        int arr1[] = {3,5,1,2,4};
        FindLastGroupM m = new FindLastGroupM();
        System.out.println(m.findLatestStep(arr1, 1));
    }

}
