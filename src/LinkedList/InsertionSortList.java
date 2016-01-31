package LinkedList;
/*
 * Leetcode 147. Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        // create a dummy new linked list
        ListNode dummy = new ListNode(0);

        ListNode cur = head;
        
        while (cur != null) {
            // start from sorted linked list
            ListNode p = dummy;
            // find the position to insert
            while (p.next != null && p.next.val < cur.val)
                p = p.next;
            // save the next
            ListNode tmp = cur.next;
            // insert into position
            cur.next = p.next;
            p.next = cur;
            cur = tmp;

        }
                
        return dummy.next;
    }

    public static void main(String args[]) {
        int a1[] = {3,4,1};
        ListNode list = ListNode.initFromArray(a1);
        list = insertionSortList(list);
        ListNode.printListNode(list);
    }
}
