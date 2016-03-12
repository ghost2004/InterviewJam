package LinkedList;
/*
 * Leetcode 86.  Partition List
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(0);
        ListNode p1 = dummy;
        ListNode dummy2 = new ListNode(0);
        ListNode p2 = dummy2;
        
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
                cur = cur.next;
                p1.next = null;
            } else {
                p2.next = cur;
                p2 = p2.next;
                cur = cur.next;
                p2.next = null;
            }
                
        }
        
        p1.next = dummy2.next;
        
        return dummy.next;
    }
}
