package arrays;
/*
 * Leetcode 985. Sum of Even Numbers After Queries
 * 
 * We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 */
public class SumEvenNumsAfterQuery {
    public int[] sumEvenAfterQueriesV1(int[] A, int[][] queries) {
        int len = queries.length;
        int res[] = new int[len];
        int evenTotal = 0;
        for (int a : A) {
            if (a % 2 == 0)
                evenTotal += a;
        }
        
        for (int i = 0; i < len; i++) {
            int t = A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            boolean before = t % 2 == 0;
            boolean after = A[queries[i][1]] % 2 == 0;
            if (before && after) {
                res[i] = evenTotal + queries[i][0];          
            } else if (!before && after) {
                res[i] = evenTotal + A[queries[i][1]];
            } else if (before && !after) {
                res[i] = evenTotal - t;
            } else {
                res[i] = evenTotal;
            }
            
            
            evenTotal = res[i];
        }
        
        return res;
    }
    
    public int[] sumEvenAfterQueriesV2(int[] A, int[][] queries) {
        int len = queries.length;
        int res[] = new int[len];
        int evenTotal = 0;
        for (int a : A) {
            if (a % 2 == 0)
                evenTotal += a;
        }
        
        for (int i = 0; i < len; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            
            if (A[idx] % 2 == 0) 
                evenTotal -= A[idx];
            A[idx] += val;
            if (A[idx] % 2 == 0) 
                evenTotal += A[idx];
            
            res[i] = evenTotal;
        }
        
        return res;
    }
    
    
}
