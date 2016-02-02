package LinkedList;
/*
 * Leetcode 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int idx = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode pCur = head;
        ListNode pNext;
        
        // reach the m point
        while (idx < m) {
            prev = pCur;
            pCur = pCur.next;
            idx++;
        }
        // the end of reverse point
        ListNode pStart = pCur;
        // the start of reverse point
        pNext = pCur.next;
        // reverse m-n
        while (idx < n) {
            idx++;
            ListNode tmp = pNext.next;
            pNext.next = pCur;
            pCur= pNext;
            pNext = tmp;
        }
        
        prev.next = pCur;
        pStart.next = pNext;
        
        return dummy.next;
    }

}
