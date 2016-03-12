package LinkedList;
/*
 * Leetcode 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // find the middle point of list by fast/flow pointer
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        // split the list into half
        fast = prev.next;
        prev.next = null;
        
        // reverse the second half
        prev = null;
        while (fast.next != null) {
            ListNode tmp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = tmp;
        }
        
        fast.next = prev;
        slow = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
                
        return true;
    }

}
