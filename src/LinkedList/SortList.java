package LinkedList;
/*
 * Leetcode 148. Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    
    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                prev = left;
                left = left.next;
            } else {
                prev.next = right;
                prev = right;
                right = right.next;
            }
        }
        
        if (left != null) 
            prev.next = left;
        else
            prev.next = right;
        
        return dummy.next;
    }
    public ListNode mergeSort(ListNode head, int length) {
        if (length == 1)
            return head;
        int mid = length/2;
        ListNode prev = head;
        // cut the list into half
        for (int i = 1; i < mid; i++)
            prev = prev.next;
        ListNode p2 = prev.next;
        prev.next = null;
        ListNode left = mergeSort(head, mid);
        ListNode right = mergeSort(p2, length - mid);
        
        return mergeList(left,right);
        
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int step = 0;
        ListNode cur = head;
        
        while (cur != null) {
            step++;
            cur = cur.next;
        }
        
        return mergeSort(head, step);
        
    }
}
