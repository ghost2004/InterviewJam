package sort;

import java.util.Arrays;

/*
 * Leetcode 274. H-Index
 * 
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 *  write a function to compute the researcher's h-index.
For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers 
in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the 
researcher has 3 papers with at least 3 citations each and the remaining two with no 
more than 3 citations each, his h-index is 3.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int hIdx = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (hIdx >= citations[i])
                return hIdx;
            hIdx++;
        }
        return hIdx;
    }
}
