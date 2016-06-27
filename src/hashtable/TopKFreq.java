package hashtable;
/*
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1<=k <= number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
import java.util.*;
public class TopKFreq {
    private class Freq {
        int num;
        int count;
        public Freq (int n, int c) {
            num = n;
            count = c;
        }
    }
    
    private Comparator<Freq> freqComparator = new Comparator<Freq> () {
        public int compare(Freq left, Freq right) {
            return left.count - right.count;
        }
    };
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i:nums) {
            Integer n = map.get(i);
            if (n == null) {
                map.put(i, 1);
            } else {
                map.put(i,n+1);
            }
                    
        }
        
        PriorityQueue<Freq> queue = new PriorityQueue<Freq>(freqComparator); 
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            Freq f = new Freq(entry.getKey(), entry.getValue());
            queue.offer(f);
            if (queue.size() > k ) {
                queue.poll();
            }
        }
        List<Integer> out = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            out.add(queue.poll().num);
            
        }
        
        Collections.reverse(out);
        return out;
        
    }
}
