/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {
    private static int timestamp=0;
    HashMap<Integer,User> userMap;
    class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.id=id;
            time=timestamp++;
            next=null;
        }
    }
    class User{
        int id;
        Set<Integer> followed;//User Id
        Tweet tweetHead;
        public User(int id){
            this.id=id;
            followed=new HashSet<Integer>();
            followed.add(id);
        }
        public void follow(int userId){
            followed.add(userId);
        }
        public void unfollow(int userId){
            if(userId!=id)
                followed.remove(userId);
        }
        public void post(int tweetId){
            Tweet tweet=new Tweet(tweetId);
            tweet.next=tweetHead;
            tweetHead=tweet;
        }
    }
    public Twitter() {
        userMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId))
            userMap.put(userId,new User(userId));
        User user=userMap.get(userId);        
        user.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        if(!userMap.containsKey(userId))
            return res;
        
        PriorityQueue<Tweet> pq=new PriorityQueue<Tweet>((x,y)->Integer.compare(y.time,x.time));
        User user=userMap.get(userId);
        Set<Integer> followed=user.followed;
        for(int id:followed){
            Tweet tweetHead=userMap.get(id).tweetHead;
            if(tweetHead!=null)
                pq.offer(tweetHead);
        }
        while(!pq.isEmpty()){
            if(res.size()==10)
                return res;
            Tweet tweet=pq.poll();
            res.add(tweet.id);
            if(tweet.next!=null)
                pq.offer(tweet.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
            userMap.put(followerId,new User(followerId));
        if(!userMap.containsKey(followeeId))
            userMap.put(followeeId,new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId))
            userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

