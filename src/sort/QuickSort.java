package sort;

public class QuickSort {
    public int partition(int nums[], int start, int end) {
        int pivot = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            //System.out.println("left "+ left+" right "+right);
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            //System.out.println("left "+ left+" right "+right);
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    public void quickSort(int nums[], int start, int end) {
        if (start >= end)
            return;
        int pos = partition(nums, start, end);
        quickSort(nums, start, pos-1);
        quickSort(nums, pos+1, end);
    }
    public void quickSort(int nums[]) {
        quickSort(nums, 0 , nums.length-1);
    }

    public static void main(String args[]) {
        QuickSort q = new QuickSort();
        int array[] = {4,3, 20, 10, 30, 30,1, -10};
        q.quickSort(array);
        for (int i:array) 
            System.out.print(i+" ");
        System.out.println();
    }
}
