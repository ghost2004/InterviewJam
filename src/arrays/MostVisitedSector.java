package arrays;
/*
 * Leetcode Most Visited Sector in a Circular Track
 * Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. 
 * A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and
 *  ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

Return an array of the most visited sectors sorted in ascending order.

Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).
 */
import java.util.*;
public class MostVisitedSector {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int count[] = new int[n+1];
        int max = 0;

        int idx = rounds[0];
        for (int i = 1; i < rounds.length; i++) {
            while (idx != rounds[i]) {
                count[idx]++;
                max = Math.max(max, count[idx]);
                idx++;
                if (idx > n)
                    idx = 1;
                
            }
        }
        count[idx]++;
        max = Math.max(max, count[idx]);
        for (int i = 1; i <= n; i++) 
            if (count[i] == max)
                list.add(i);

        return list;

    }
    
    public static void main(String args[]) {
        MostVisitedSector m = new MostVisitedSector();
        int rounds[] = {2,1,2,1,2,1,2,1,2};
        
        m.mostVisited(2, rounds);
    }

}
