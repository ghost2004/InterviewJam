package hashtable;
/*
 * LeetCode 721. Accounts Merge
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 *  and the rest of the elements are emails representing emails of the account, in sorted order.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that 
is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people 
could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the 
same name.

After merging the accounts, return the accounts in the format they were given: the first element of each account is the name, 
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

    Example 1:
    Input: 
    accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], 
    ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
    Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], 
    ["Mary", "mary@mail.com"]]
    
    Explanation: 
    The first and third John's are the same person as they have the common email "johnsmith@mail.com".
    The second John and Mary are different people as none of their email addresses are used by other accounts.
    We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
    ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
    Note:
    
    The length of accounts will be in the range [1, 1000].
    The length of accounts[i] will be in the range [1, 10].
    The length of accounts[i][j] will be in the range [1, 30].
 */
import java.util.*;

public class MergeAccount {

    // Map from one email address to other connected email address
    private HashMap<String, Set<String>> eamilGraph;
    private Set<String> visited;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        eamilGraph = new HashMap<>();
        for (List<String> emailList : accounts) {
            for (int i = 1; i < emailList.size(); i++) {
                Set<String> set = eamilGraph.get(emailList.get(i));
                if (set == null) {
                    set = new HashSet<String>();
                    eamilGraph.put(emailList.get(i), set);
                }
                if (i == 1) continue;
                set.add(emailList.get(1));
                eamilGraph.get(emailList.get(1)).add(emailList.get(i));
            }
        }
        
        visited = new HashSet<>();
        for (List<String> account : accounts) {
            if (!visited.contains(account.get(1))) {
                List<String> list = new ArrayList<>();
                bfs(account.get(1), list);
                Collections.sort(list);
                list.add(0, account.get(0));
                res.add(list);
            }
        }
        return res;
        
    }
    
    private void bfs(String start, List<String> list) {
        Queue<String> q = new LinkedList<String>();
        
        q.offer(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            list.add(cur);
            Set<String> set = eamilGraph.get(cur);
            for (String s : set) {
                if (!visited.contains(s)) {
                    q.offer(s);
                    visited.add(s);
                }
            }
        }
        
    }
    
    
}
