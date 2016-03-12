package LinkedList;
/*
 * Leetcode 82. Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicateII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode p;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                p = cur.next;
                while (p != null && cur.val == p.val) 
                    p = p.next;
                prev.next = p;
                cur = p;
            } else {
                prev = cur;
                cur = cur.next;

            }
        }
        
        
        return dummy.next;
    }
}
