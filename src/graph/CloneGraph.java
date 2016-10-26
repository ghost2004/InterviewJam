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
        // queue for BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        // map from original nodes to new nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        // clone the start node first
        UndirectedGraphNode newHead =  new UndirectedGraphNode(node.label);
        UndirectedGraphNode orig, clone;
        map.put(node, newHead);
        queue.add(node);
        // BFS
        while (!queue.isEmpty()) {
            // get the node from queue
            orig = queue.poll();
            // check its neighbors
            for (UndirectedGraphNode n : orig.neighbors) {
                if (map.containsKey(n)) {
                    // the neighbor is already cloned, add neighbor relation in the cloned one
                    map.get(orig).neighbors.add(map.get(n));
                } else {
                    // the neighbor is not cloned yet
                    clone = new UndirectedGraphNode(n.label);
                    map.get(orig).neighbors.add(clone);
                    map.put(n, clone);
                    // add this node to queue -- not visited yet
                    queue.add(n);
                }
            }
        }
        
        return newHead;
        
    }
}
