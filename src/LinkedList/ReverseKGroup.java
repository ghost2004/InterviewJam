package LinkedList;
/*
 * 
 * Leetcode 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {
    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     * after call pre = reverse(pre, next)
     * 
     * step 0
     * 0----->1----->2---->3---->4->5->6
     * |      |      |           |   
     * pre   tail    cur        next     
     * step1
     * 0----->2----->1---->3---->4->5->6
     * |             |     |     |   
     * pre          tail  cur  next  
     * 
     * 0----->3----->2---->1---->4->5->6
     * |                   |     |   
     * pre               tail next==cur  
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     *          
     * @param prev 
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    public ListNode reverse2(ListNode prev, ListNode next) {
        ListNode tail = prev.next;
        ListNode pCur = tail.next;
        
        while (pCur != next) {
            tail.next = pCur.next;
            pCur.next = prev.next;
            prev.next = pCur;
            pCur = tail.next;
        }
        
        return tail;
        
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int step = 0;

        while (cur != null) {
            step++;
            if (step % k == 0) {
                prev = reverse2(prev, cur.next);
                cur = prev.next;
            } else 
                cur = cur.next;
        }
        
        return dummy.next;
    }

}
