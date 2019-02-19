package graph;

import java.util.*;

/*
 * Leetcode 815. Bus Routes
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. 
 * For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in
 *  the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Traveling 
by buses only, what is the least number of buses we must take to reach our destination?
 Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.
 */
public class BusRoute {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, List<Integer>> routeMap = new HashMap<>();
        
        
        int ret = 0;
        
        // if the destination is the source
        if (S == T) {
            return ret;
        }
        
        // build the map from each stop to its routes
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> routeList = routeMap.getOrDefault(routes[i][j], new ArrayList<>());
                routeList.add(i);
                routeMap.put(routes[i][j],  routeList);
            }
        }
        
        // visited bus routes is empty at the beginning
        HashSet<Integer> visitedRoutes = new HashSet<>();
        // started at S stop
        Queue<Integer> stopList = new LinkedList<>();
        stopList.offer(S);
        
        // BFS
        while(!stopList.isEmpty()) {
            ret++;
            int length = stopList.size();
            for (int i = 0; i < length; i++) {
                int curStop = stopList.poll();
                List<Integer> routeList = routeMap.get(curStop);
                for (Integer route:routeList) {
                    // already used this route before, skip it
                    if (visitedRoutes.contains(route))
                        continue;
                    // add current route to the visited 
                    visitedRoutes.add(route);
                    for (int j = 0; j < routes[route].length; j++) {
                        int nextStop = routes[route][j];
                        if (nextStop == T)
                            return ret;
                        stopList.offer(nextStop);
                    }
                    
                }
            }
        }
        
        return -1;
        
    }

}
