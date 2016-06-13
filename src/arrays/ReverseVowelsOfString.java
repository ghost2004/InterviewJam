package arrays;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 * 
 */
public class ReverseVowelsOfString {
    private int findVowel(char a[], int start, int step) {
        int idx = start;
        while (idx >= 0 && idx < a.length) {
            char c = a[idx];
            if (c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u'
             || c == 'A' || c == 'E' || c == 'O' || c == 'I' || c == 'U') 
                break;
            idx+=step;
        }
        return idx;
    }
   
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2)
            return s;
        char array[] = s.toCharArray();
        
        int left = findVowel(array, 0 , 1);
        int right = findVowel(array, s.length()-1 , -1);
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            
            left = findVowel(array, left+1 , 1);
            right = findVowel(array, right-1 , -1);
                    
        }
        
        return new String(array);
    }
    
    public static void main(String args[]) {
        ReverseVowelsOfString r = new ReverseVowelsOfString();
        System.out.println(r.reverseVowels("hello"));
    }
}
