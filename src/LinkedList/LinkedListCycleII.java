package LinkedList;
/*
 *  Leetcode 142. Linked List Cycle II
 *  
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 *  
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = head;
        while (fast != slow.next) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}
