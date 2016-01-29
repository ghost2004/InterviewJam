package LinkedList;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pRight = head;
        ListNode pLeft = head;
        ListNode prev = fake;
        int step = 0;
        while (step < n && pRight != null) {
            pRight = pRight.next;
            step++;
        }
        
        if (step != n) 
            return head;
        while( pRight !=null) {
            prev = pLeft;
            pLeft = pLeft.next;
            pRight = pRight.next;
        }
        
        prev.next = pLeft.next;
        
        return fake.next;
    }
    
    public static void main(String args[]) {
        int a1[] = {1,2};
        ListNode p = ListNode.initFromArray(a1);
        p = removeNthFromEnd(p, 1);
        ListNode.printListNode(p);
    }

}
