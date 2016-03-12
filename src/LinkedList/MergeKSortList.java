package LinkedList;
/*
 * Leetcode 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity. 
 */
public class MergeKSortList {
    
    public ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
            cur.next = null;
        }
        
        if (left != null)
            cur.next = left;
        else
            cur.next= right;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists,int start, int end) {
        if (start == end)
            return lists[start];
        else if (end < start)
            return null;
        int mid = (start + end)/2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid+1, end);
        
        ListNode out = mergeTwoList(left, right);
        
        return out;
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length-1);
    }

}
