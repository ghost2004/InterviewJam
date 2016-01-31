package LinkedList;
/*
 *  Leetcode 160. Intersection of Two Linked Lists
 *  
 *  Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class InterscetionOf2List {
    
    public int getListLength(ListNode head) {
        ListNode cur = head;
        int step = 0;
        while (cur != null) {
            cur = cur.next;
            step++;
        }
        return step;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        int diff = Math.abs(lenA-lenB);
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        if (lenB > lenA) {
            p2 = headA;
            p1 = headB;
        }
        
        for (int i = 0; i < diff; i++) {
            p1 = p1.next;
        }
        
        while (p1 != null) {
            if (p1 == p2) 
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return null;
    }

}
