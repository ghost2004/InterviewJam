package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPQTest {
    MaxPQ pq;
    @Test
    public void testOffer() {
        pq = new MaxPQ(10);
        assertEquals(true, pq.isEmpty());
        pq.offer(1);
        assertEquals(1, pq.size());
        assertEquals(1, pq.poll());
        assertEquals(true, pq.isEmpty());
        pq.offer(2);
        pq.offer(1);
        pq.offer(10);
        pq.offer(9);
        pq.offer(7);
        assertEquals(5, pq.size());
        assertEquals(10, pq.poll());
        assertEquals(9, pq.poll());
        assertEquals(7, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(1, pq.size());
        assertEquals(1, pq.poll());
        assertEquals(true, pq.isEmpty());
        
    }



}
