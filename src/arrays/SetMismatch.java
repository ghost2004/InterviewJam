package arrays;
/*
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, 
 * one of the numbers in the set got duplicated to another number in the set, which results in 
 * repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly 
find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
 */
public class SetMismatch {
    public int[] findErrorNums2(int[] nums) {
        int out[] = new int[2];
        int i;
        short bitmap[] = new short[(nums.length)+1];
        
        for (i = 0; i < nums.length; i++) {
            bitmap[nums[i]]++;
            if (bitmap[nums[i]] > 1)
                out[0] = nums[i];

        }
        
        for (i = 1; i < bitmap.length; i++) {
            if (bitmap[i] == 0) {
                out[1] = i;
                break;
            }
        }
        
        
        return out;
        
    }
    
    
    public int[] findErrorNums(int[] nums) {
        int out[] = new int[2];
        int i;
        int bitmap[] = new int[(nums.length/32)+1];
        
        for (i = 0; i < nums.length; i++) {
            int idx = nums[i]/32;
            int offset = nums[i] % 32;
            if ((bitmap[idx] & (1 << offset)) != 0) {
                out[0] = nums[i];
            } else {
                bitmap[idx] |= 1 << offset;
            }
            

        }
        
        for (i = 0; i < bitmap.length; i++) {
            if (bitmap[i] == 0xffffffff)
                continue;
            break;
        }
        
        
        return out;
        
    }
    
    public static void main(String args[]) {
        SetMismatch s = new SetMismatch();
        int a1[] = { 1, 2, 2, 4};
        
        int a[] = s.findErrorNums2(a1);
        System.out.println(a[0] +" " + a[1]);
    }

}
