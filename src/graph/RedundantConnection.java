package graph;


/*
 * 
 * Leetcode 684. Redundant Connection
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional edge added. The added edge has two different vertices chosen from 1 to N, and 
was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
 that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple 
answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the
 same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnection {
    
    class UnionFind {
        private int parent[];
        
        public UnionFind(int n) {
            parent = new int[n+1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }
        
        public int find(int x){
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
        
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            parent[pa] = pb;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind union = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            if (union.find(edges[i][0]) == union.find(edges[i][1])) {
                return edges[i];
            }
            union.union(edges[i][0], edges[i][1]);
        }
        return null;
    }

}
