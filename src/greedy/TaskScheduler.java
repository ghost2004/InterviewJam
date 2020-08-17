package greedy;

/*
 * Leetcode 621. Task Scheduler
 * 
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents 
 * a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each 
 * unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), 
that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
import java.util.*;
public class TaskScheduler {
    // solution with math
    // O(n) in time and O(1) in space
    public int leastInterval(char[] tasks, int n) {
        int counters[] = new int[26];
        // the most frequent task
        int max = 0;
        // the number of most frequent task
        int maxCount = 0;
        for (char c : tasks) {
            int idx = c - 'A';
            counters[idx]++;
            if (max < counters[idx]) {
                max = counters[idx];
                maxCount = 1;
            } else if (max == counters[idx]) {
                maxCount++;
            }
        }
        
        
        // always choose most frequent task first, so it will be repeated in A x x A x x A 
        // Ignore the last one, the number of partition is most frequency minus one 
        int partitionNumber = max - 1;
        // for each partition the length should be n + 1, and first x will be taken by most frequent tasks 
        int partitionLength = n + 1 - maxCount;
        // after scheduled those frequent tasks, remaining available slots are for other tasks
        int emptySlots = partitionNumber * partitionLength;
        // here is  the number of tasks that not scheduled yet
        int availableTasks = tasks.length - max * maxCount;
        // fit those unscheduled tasks into empty slots. 
        // the worst case is there is not enough space for it, in this case it should be the length of tasks
        int idle = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idle;
    }
    
    // solution with priority queue
    public int leastIntervalPQ(char[] tasks, int n) {
        int counters[] = new int[26];
        for (char c : tasks) {
            int idx = c - 'A';
            counters[idx]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a);
        for (int count : counters)
            if (count != 0) pq.add(count);
        
        // map from time to task 
        Map<Integer, Integer> timeMap = new HashMap<>();
        // let's mark the start time as 0, it won't have any task at this moment
        int time = 0;
        int remainingTasks = tasks.length;
        while (remainingTasks > 0) {
            // check if there is task been scheduled at this time
            Integer taskNum = timeMap.get(time);
            if (taskNum != null && taskNum > 1) {
                // it is scheduled before, and it still need to be run later
                pq.add(taskNum -1);
            }
            // get the next candidate task
            Integer cur = pq.poll();
            if (cur != null) {
                remainingTasks--;
                // the next time for schedule this task is plus n + 1
                timeMap.put(time + n + 1, cur);
            }
            time++;
                
        }
        
        return time;
    }

}
