package Trees;
/*
 * Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle 
of the first row it can be put.
The column and the row where the root node belongs will separate the rest 
space into two parts 
(left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print 
the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size.
 Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still
  need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't 
  need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
 */
import java.util.*;
public class PrintBinaryTree {
    
    private class NodeTrack {
        TreeNode node;
        int idx;
    }

    public List<List<String>> printTree(TreeNode root) {
        
        List<List<String>> out = new ArrayList<List<String>>();
        
        if (root == null)
            return out;
        
        List<List<NodeTrack>> track = new  ArrayList<List<NodeTrack>>();
        LinkedList<NodeTrack> cur = new LinkedList<NodeTrack>();
        
        
        NodeTrack first = new NodeTrack();
        first.node = root;
        first.idx = 0;
    

        cur.offer(first);
        
        while (!cur.isEmpty()) {

            LinkedList<NodeTrack> curLevel = new LinkedList<NodeTrack>();
            LinkedList<NodeTrack> next = new LinkedList<NodeTrack>();

            while (!cur.isEmpty()) {
                NodeTrack tnode = cur.poll();
                curLevel.add(tnode);
                NodeTrack t; 
                if (tnode.node.left != null) {
                    t = new NodeTrack();
                    t.node = tnode.node.left;
                    t.idx = tnode.idx * 2;
                    next.offer(t);
                }
                if (tnode.node.right != null) {
                    t = new NodeTrack();
                    t.node = tnode.node.right;
                    t.idx = tnode.idx * 2 + 1 ;
                    next.offer(t);
                }
            }
            track.add(curLevel);
            cur = next;
        }
        
        int column = (1 << track.size()) -1;
        for (int i = 0 ; i < track.size(); i++) {
            List<NodeTrack> curLevel = track.get(i);
            ArrayList<String> level = new ArrayList<String>(column);
            for (int j = 0; j < column; j++) {
                level.add("");
            }
            
            int start = (1 << (track.size() - i -1)) - 1;
            int jump = 1 << (track.size() - i);
            for (NodeTrack t : curLevel) {
                level.set(start + t.idx * jump, new Integer(t.node.val).toString());
            }
            
            out.add(level);
        }
        
        return out;
    }


}
