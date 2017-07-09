package Trees;
/*
 * 
 * Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
import java.util.*;
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> out  = new ArrayList<Double>();
        if (root == null)
            return out;
        
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();     
        
        next.offer(root);
        
        while (!next.isEmpty()) {
            cur = next;
            next = new LinkedList<TreeNode>();  
            long totalNum = 0;
            long totalVal = 0;
            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
                totalNum++;
                totalVal+=node.val;
            }
            out.add(new Double(1.0*totalVal/totalNum));
        }
        
        return out;
    }
}
