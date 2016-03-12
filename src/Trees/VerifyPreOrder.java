package Trees;
/*
 * 
 * Leetcode 331. Verify Preorder Serialization of a Binary Tree
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a 
 * non-null node, we record the node's value. If it is a null node, we record using a 
 * sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal 
serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing
 null pointer.

You may assume that the input format is always valid, for example it could never contain two
 consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 */
import java.util.*;
public class VerifyPreOrder {
    

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return true;
        
        LinkedList<String> list = new LinkedList<String>();
        
        list.addAll(Arrays.asList(preorder.split(",")));
        
        Stack<String> stack = new Stack<String>();
        
        stack.push(list.poll());

        
        while (!list.isEmpty() && !stack.isEmpty()) {
            String node = list.poll();
            if (node.equals("#") && stack.peek().equals("#")) {
                if (stack.size() < 2)
                    return false;
                stack.pop();
                stack.pop();
                while (!stack.isEmpty() &&stack.peek().equals("#")) {
                    if (stack.size() < 2)
                        return false;
                    stack.pop();
                    stack.pop(); 
                }
                
            } 
            stack.push(node);
        }
        
        if (stack.size() == 1 && stack.peek().equals("#"))
            return true;

        return false;
    }

}
