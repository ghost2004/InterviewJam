package heap;
/*
 * Leetcode 295. Find Median from Data Stream
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
 */
import java.util.*;
public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public void addNum2(int num) {
        if (minHeap.size()> 0 && num >= minHeap.peek()) {
            minHeap.offer(num);
            if (maxHeap.size() < minHeap.size())
                maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size()+1)
                minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        else
            return maxHeap.peek();
    }
}
