package com.sailing.leetcode.solution355;

import java.util.*;

public class Twitter {
    static class Pair{
        Integer data;
        long t;

        public Pair(int tweetId, long t) {
            this.data = tweetId;
            this.t = t;
        }
    }

    long t = 0;
    private Map<Integer, LinkedList<Pair>> tw = new HashMap<>();
    private Map<Integer, Set<Integer>> follow = new HashMap<>();


    /** Initialize your data structure here. */

    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Pair> feeds = tw.get(userId);
        if(feeds == null){
            feeds = new LinkedList<>();
            tw.put(userId, feeds);
        }
        Pair feed = new Pair(tweetId, t);
        feeds.addFirst(feed);
        t++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        Set<Integer> followeeids = follow.get(userId);
        if(followeeids == null){
            followeeids = new HashSet<>();
            follow.put(userId, followeeids);
        }
        followeeids.add(userId);

        for (Integer followee : followeeids){
            LinkedList<Pair> feeds = tw.get(followee);
            int count = 0;
            if(feeds != null){
                for(Pair p : feeds){
                    map.put(p.t, p.data);
                    count ++;
                    if(count == 10){
                        break;
                    }
                }
            }
        }

        int count = 0;
        List<Integer> feeds = new ArrayList<>();
        for (Integer feed : map.descendingMap().values()){
            feeds.add(feed);
            count ++;
            if(count == 10){
                break;
            }
        }

        return feeds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeids = follow.get(followerId);
        if(followeeids == null){
            followeeids = new HashSet<>();
            follow.put(followerId, followeeids);
        }
        followeeids.add(followeeId);

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeids = follow.get(followerId);
        if(followeeids != null){
            followeeids.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 1);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(2, 1);

        // User 2 posts a new tweet (id = 6).
//        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(2);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
    }
}
