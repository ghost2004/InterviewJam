package Trees;
/*
 * Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 *  two given nodes in the BST.

According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor 
is defined between two nodes v and w as the lowest node in T that has both v 
and w as descendants (where we allow a node to be a descendant of itself).¡±

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another 
example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of 
itself according to the LCA definition.
 */
public class LCAofBST {
    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if (node.val > p.val && node.val < q.val)
            return node;
        if (node.val == p.val || node.val == q.val)
            return node;
        
        if (node.val > q.val)
            return lca(node.left, p, q);
        
        return lca(node.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode p1, q1;
        if (p.val < q.val) {
            p1  = p;
            q1 = q;
        } else {
            p1 = q;
            q1 = p;
        }
        
        return lca(root, p1, q1);
    }

}
