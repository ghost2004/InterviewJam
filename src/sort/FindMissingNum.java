package sort;
/*
 * Interview question from Facebook
 * 
 * Given an sorted array with distinct N numbers in [0, N], find the missing one
 * 
 * For example [0,1,3], return 2
 */
public class FindMissingNum {

    public int findMissing(int array[]) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = (left+right)/2;
            if (array[mid] > mid) {
                right = mid-1;
                
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}
