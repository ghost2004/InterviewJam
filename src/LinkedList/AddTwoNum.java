package LinkedList;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain
 *  a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        ListNode cur = null;
        
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int num = carry;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            
            cur = new ListNode (num%10);
            carry = num/10;
            prev.next = cur;
            prev = cur;
                
        }
        return head.next;
        
    }
}
