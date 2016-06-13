package arrays;
/*
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString {
    
    public String reverseString(String s) {
        if (s == null || s.length() < 2)
            return s;
        char array[] = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        char tmp;
        while (left < right) {
            tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        
        return (new String(array));
    }

}
