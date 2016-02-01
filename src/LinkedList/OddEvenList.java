package LinkedList;
/*
 * Leetcode 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 *  Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenList {
    
    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode odd = head;
        
        ListNode even = head.next;
        ListNode evenStart = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenStart;

        return head;        
    }

    public static void main(String args[]) {
        int arr1[] = {1,2,3};
        ListNode t = ListNode.initFromArray(arr1);
        ListNode.printListNode(oddEvenList(t));
    }
}
