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
    HashMap<Integer, HashSet<Integer>> followeeMap;
    HashMap<Integer, List<Integer>> twitterMap;
    
    
    /** Initialize your data structure here. */
    public Twitter() {
        followeeMap = new HashMap<Integer, HashSet<Integer>>();
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    }
}
