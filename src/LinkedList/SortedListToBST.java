package LinkedList;
import Trees.TreeNode;
/*
 * 109. Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class SortedListToBST {
    
    ListNode h;
    
    public TreeNode sortedList2BST(int start, int end) {
        if (start > end)
            return null;
        
        int mid = (end+start)/2;
        TreeNode left = sortedList2BST(start, mid-1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedList2BST(mid+1, end);
        root.left = left;
        root.right = right;
        
        return root;
        
    }

    public int getListLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            length++;
        }
        
        return length;
               
    }
    
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;
        int length = getListLength(head);
        h = head;
        
        return sortedList2BST(0, length-1);
    }
    
    public static void main(String args[]) {
        SortedListToBST s =new SortedListToBST();
        int arr1[] = {1,3};
        ListNode node = ListNode.initFromArray(arr1);
        TreeNode t = s.sortedListToBST(node);
        System.out.println(t.serialize());
        
    }

}
