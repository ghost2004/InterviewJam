package graph;
/*
 * Leetcode 133. Clone Graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
import java.util.*;
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode newHead =  new UndirectedGraphNode(node.label);
        UndirectedGraphNode orig, clone;
        map.put(node, newHead);
        queue.add(node);
        while (!queue.isEmpty()) {
            orig = queue.poll();
            for (UndirectedGraphNode n : orig.neighbors) {
                if (map.containsKey(n)) {
                    map.get(orig).neighbors.add(map.get(n));
                } else {
                    clone = new UndirectedGraphNode(n.label);
                    map.get(orig).neighbors.add(clone);
                    map.put(n, clone);
                    queue.add(n);
                }
            }
        }
        
        return newHead;
        
    }
}
