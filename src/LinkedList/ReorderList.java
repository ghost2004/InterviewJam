package LinkedList;
/*
 * Leetcode 143. Reorder List
 * 
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public ListNode reverse(ListNode h) {
        if (h == null || h.next == null)
            return h;
        ListNode prev = h;
        ListNode cur = h.next;
        prev.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head.next;
        // cut the list into half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode p2 = slow.next;
        slow.next = null;
        
        // reverse the second part
        p2 = reverse(p2);
        
        // combine these 2 lists into one
        ListNode p1 = head;
        while (p1 != null && p2 != null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }
        
    }
}
