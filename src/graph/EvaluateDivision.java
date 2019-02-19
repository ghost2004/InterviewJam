package graph;
/*
 * Leetcode 399. Evaluate Division
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, 
 * and k is a real number (floating point number). Given some queries, return the answers. 
 * If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , 
where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
import java.util.*;

public class EvaluateDivision {
    
    private Map<String, Map<String, Double>> rateMap;

    private double dfs(String x, String y, Set<String> visited) {
        if (x.equals(y)) return 1.0;
        visited.add(x);
        Set<String> keys = rateMap.get(x).keySet();
        
        for(String s:keys) {
            if (visited.contains(s)) continue;
            double value = dfs(s, y, visited);
            if (value > 0) {
                return value*rateMap.get(x).get(s);
            }
                
        }
        return -1.0;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        rateMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            rateMap.computeIfAbsent(x, k -> new HashMap<String, Double>()).put(y, values[i]);
            rateMap.computeIfAbsent(y, k -> new HashMap<String, Double>()).put(x, 1/values[i]);
        }
        
        double ans[] = new double[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!rateMap.containsKey(x) || !rateMap.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(x, y, new HashSet<String>());
            }
        }
        
        return ans;
        
    }

}
