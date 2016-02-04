package LinkedList;
/*
 * Leetcode 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.

 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur!= null && cur.next != null) {
            ListNode next = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            prev = cur;
            cur = cur.next;
        }
        
        return dummy.next;
    }

}
