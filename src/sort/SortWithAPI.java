package sort;
/*
 * Interview question from Facebook
 * 
 * Given an array with 3 APIs , sort the array
 * isSmall(), isMedian(), isBig()
 * Only one of these will return true for one element
 */
public class SortWithAPI {
    private boolean isSmall(int i) {
        return i < 10;
    }
    private boolean isMedian(int i) {
        return i >= 10 && i <= 99;
    }
    private boolean isBig(int i) {
        return i >= 100;
    }
    private void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public void dump(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
    
    private int getLength(int data) {
        int len = 0;
        while (data > 0) {
            data /= 10;
            len++;
        }
        return len;
    }
    
    public boolean valid(int array[]) {
        int cur = getLength(array[0]);
        for (int i = 1; i < array.length; i++) {
            int flag = getLength(array[i]);
            if (flag < cur)
                return false;
            cur = flag;
        }
        return true;
    }
    
    public void sort(int array[]) {
        int bigIdx = array.length-1;
        int smallIdx = 0;
        int idx = 0;
        
        while (idx <= bigIdx) {
            if (isSmall(array[idx])) {
                swap(array, idx, smallIdx);
                idx++;
                smallIdx++;
            } else if (isBig(array[idx])) {
                swap(array, idx, bigIdx);
                bigIdx--;
            } else {
                idx++;
            }
        }
    }

    public static void main(String args[]) {
        int a1[] = {40, 9,20, 100,1};
        SortWithAPI s = new SortWithAPI();
        s.sort(a1);
        
        s.dump(a1);
        
        int a3[] = {10,41,25,7};
        s.sort(a3);
        
        s.dump(a3);
        
    }
}
