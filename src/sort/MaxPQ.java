package sort;
/*
 * Implementation of Max Heap
 */
public class MaxPQ {
    private int[] pq;
    private int N;
    public MaxPQ (int cap) {
        pq = new int[cap+1];
        N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    
    private void exch(int left, int right) {
        int tmp = pq[left];
        pq[left] = pq[right];
        pq[right] = tmp;
    }
    
    private void swim(int idx) {
        while (idx >1 && pq[idx] > pq[idx/2]) {
            exch(idx/2, idx);
            idx = idx/2;
        }
    }
    
    private void sink(int idx) {
        while (2*idx <= N) {
            int child = 2*idx;
            if (child < N && pq[child+1] > pq[child])
                child ++;
            if (pq[child] <= pq[idx])
                break;
            exch(idx, child);
            idx = child;
        }
    }
    
    public void offer(int key) {
        pq[++N] = key;
        swim(N);
    }
    
    public int poll() {
        int max = pq[1];
        pq[1] = pq [N];
        N--;
        sink(1);
        pq[N+1] = -1;
        return max;
    }
    
    

}
