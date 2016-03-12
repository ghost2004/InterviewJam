package LinkedList;
/*
 * Leetcode 206. Reverse Linked List
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode second = head.next;
        
        head.next = null;
        ListNode rest = reverseList(second);
        second.next = head;
        return rest;
    }
    
    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
}
