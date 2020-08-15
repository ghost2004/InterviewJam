package arrays;
/*
 * Leetcode 1502. Can Make Arithmetic Progression From Sequence

Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

 

Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 */
import java.util.*;
public class ArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) 
            return true;
        
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < arr.length; i ++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);            
        }

        if ((max - min) % (arr.length - 1) != 0)
            return false;
        int delta = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(min + i*delta))
                return false;
        }
        
        
        return true;
        
    }
    
    public static void main(String args[]) {
        ArithmeticProgression arr = new ArithmeticProgression();
        int a1[] = {-68,-96,-12,-40,16};
        System.out.println(arr.canMakeArithmeticProgression(a1));
    }
}