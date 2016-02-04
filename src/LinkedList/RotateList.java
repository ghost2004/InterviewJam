package LinkedList;
/*
 * Leetcode 61. Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int length = 1;
        ListNode cur = head;
        
        // get the length of list
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        
       
        if (k % length == 0)
            return head;
       
        // make a circle
        cur.next = head;
        cur = head;
        int step = length - k%length - 1;
        
        for (int i = 0; i < step; i++)
            cur = cur.next;
        // find the break point
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}
