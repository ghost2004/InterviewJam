package hashtable;
/*
 *  Leetcode 355. Design Twitter
 *  
 *  Design a simplified version of Twitter where users can post tweets, follow/unfollow another
 *   user and is able to see the 10 most recent tweets in the user's news feed. Your design should
 *    support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the
 news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered
  from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
 */
import java.util.*;
public class Twitter {
    
    class TwMsg {
        public int tw_id;
        public int timestamp;
    }
    HashMap<Integer, HashSet<Integer>> followeeMap;
    HashMap<Integer, ArrayList<TwMsg>> selfTwtrMap;
    
    int time;
    
    /** Initialize your data structure here. */
    public Twitter() {
        followeeMap = new HashMap<Integer, HashSet<Integer>>();
        selfTwtrMap = new HashMap<Integer, ArrayList<TwMsg>>  ();

        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        TwMsg  msg = new TwMsg();
        msg.tw_id = tweetId;
        msg.timestamp = time++;
        ArrayList<TwMsg> list = selfTwtrMap.get(userId);
        if (list == null) {
            list = new ArrayList<TwMsg>();
            selfTwtrMap.put(userId, list);
        }
        list.add(msg);
        
    }
    
    private void feedTw(PriorityQueue<TwMsg> pq, TwMsg msg) {
        pq.offer(msg);
        if (pq.size() > 10)
            pq.poll();
    }
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> feed = new LinkedList<Integer>();
        HashSet<Integer> set = followeeMap.get(userId);
        ArrayList<TwMsg> list;        
        if (set == null)
            set = new HashSet<Integer>();
        set.add(userId);
        PriorityQueue<TwMsg> pq = new PriorityQueue<TwMsg>(new Comparator<TwMsg>(){
            public int compare(TwMsg a, TwMsg b) {
                return b.timestamp - a.timestamp;
            }
        });
        
        for (int uid:set) {
            list = selfTwtrMap.get(uid);
            if (list != null) {
                int cnt = Math.min(10, list.size());
                for (int i = 0; i < cnt;i++) {
                    TwMsg msg = list.get(list.size()-i-1);
                    feedTw(pq, msg);
                }
            }
        }
        
        while (!pq.isEmpty()) {
            feed.addFirst(pq.poll().tw_id);
        }
        
        return feed;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = followeeMap.get(followerId);
        if (set == null) {
            set = new HashSet<Integer>();
            followeeMap.put(followerId, set);
        }
        set.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return ;
        HashSet<Integer> set = followeeMap.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }
}
