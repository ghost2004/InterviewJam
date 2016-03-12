package LinkedList;
/*
 * Leetcode  141. Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null) {
            if (fast == slow)
                return true;
            slow = slow.next;
            if (fast.next == null)
                break;
            fast = fast.next.next;
        }
        
        return false;
    }

}
