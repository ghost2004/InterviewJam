package LinkedList;
/*
 * Leetcode 138. Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        // duplicate list
        while (cur != null) {
            RandomListNode n = new RandomListNode(cur.label);
            n.next = cur.next;
            cur.next = n;
            cur = n.next;
        }
        // hard copy random pointer
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // split the list
        RandomListNode copy = head.next;
        RandomListNode p2 = copy;
        cur = head;
        while (cur != null) {
            cur.next = cur.next.next;
            if (cur.next != null)
                p2.next = cur.next.next;
            cur = cur.next;
            p2 = p2.next;
            
        }
            
        return copy;
    }

}
