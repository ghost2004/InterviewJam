package sort;
/*
 * Leetcode 275. H-Index II
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 *  Could you optimize your algorithm?
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int left = 0;
        int length = citations.length;
        int right = length - 1;
        
        while (left <= right) {
            int mid = (left+right)/2;
            if (citations[mid] == length - mid) 
                return citations[mid];
            else if (citations[mid] > length - mid)
                right = mid -1;
            else 
                left = mid + 1;
        }
        
        return length - left;
    }
}
