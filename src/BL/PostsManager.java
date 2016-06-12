package BL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entities.Tweet;
import entities.User;

public class PostsManager {
	
    private Map<Integer,User> hmUsers = new HashMap<Integer,User>();
    private static int tweetsIDGenerator;
    
    /** Initialize your data structure here. */
    public PostsManager() {
    	this.initialize();
    }
    
    private void initialize() {

    	User user1 = new User();
    	user1.setUserid(1);
    	user1.setUsername("Blue Elephant");
    	List<Integer> lst = new ArrayList<Integer>();
    	lst.add(2);
    	lst.add(3);
    	user1.setFollowers(lst);
    	
    	User user2 = new User();
    	user2.setUserid(2);
    	user2.setUsername("Red Carrot");
    	lst = new ArrayList<Integer>();
    	lst.add(3);
    	user2.setFollowers(lst);
    	
    	User user3 = new User();
    	user3.setUserid(3);
    	user3.setUsername("Shubi Dubi");
    	
    	Tweet tweet1 = new Tweet(tweetsIDGenerator++,
    			1,
    			"What's all about?",
    			"Dear friends, today I saw a blue elephant! " + this.hmUsers.get(1).getUsername(),
    			new Date());
    	Tweet tweet2 = new Tweet(tweetsIDGenerator++,
    			2,
    			"Hello World",
    			"I Can't believe that I write a Twitter! " + this.hmUsers.get(1).getUsername(),
    			new Date());
    	Tweet tweet3 = new Tweet(tweetsIDGenerator++,
    			3,
    			"Hello World",
    			"I Can't believe that I write a Twitter! " + this.hmUsers.get(2).getUsername(),
    			new Date());
    	
    	List<Tweet> lstTweets1 = new ArrayList<Tweet>();
    	lstTweets1.add(tweet1);
    	lstTweets1.add(tweet2);
    	
    	user1.setTweets(lstTweets1);
    	
    	List<Tweet> lstTweets2 = new ArrayList<Tweet>();
    	lstTweets2.add(tweet3);
    	
    	user1.setTweets(lstTweets2);
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, String header, String text) {
    	
    	Tweet tweet = new Tweet(tweetsIDGenerator++, userId, header, text, new Date());
    	
    	if (this.hmUsers.containsKey(userId)) {
	    	User user = this.hmUsers.get(userId);
			user.getTweets().add(tweet);
    	}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public JSONArray getNewsFeed(int userId) {   
        List<Tweet> lstAllTweets = new ArrayList<Tweet>();
        
        JSONArray jsonarray = new JSONArray();
        
        User currUser = null;
    	if (this.hmUsers.containsKey(userId)) {
	    	currUser = this.hmUsers.get(userId);
    	}
    	
    	if (currUser == null) {
    		return jsonarray;
    	}
        
    	lstAllTweets.addAll(currUser.getTweets());
    	
        List<Integer> lstUserFollowed = currUser.getFollowers();
    	
        if (lstUserFollowed != null) {
	        for (Integer userID : lstUserFollowed) {
	            User user = null;
	        	if (this.hmUsers.containsKey(userID)) {
	        		user = this.hmUsers.get(userID);
	        		if (user.getUserid() == userID) {
	    	        	List<Tweet> lstTweets = user.getTweets();
	    	        	if (lstTweets != null) {
	    	        		lstAllTweets.addAll(lstTweets);
	    	        	}
	        		}
	        	}
        	}
        }
    	
		for (Tweet tweet : lstAllTweets) {
			JSONObject jsontweet = new JSONObject();
			try {
				jsontweet.put("title", tweet.getHeader());
				jsontweet.put("content", tweet.getText());
				jsontweet.put("userName", this.hmUsers.get(tweet.getUserid()));
				jsontweet.put("creationDate", tweet.getCreationDate());
				
				jsonarray.put(jsontweet);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
        
        return jsonarray;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	
    	if (followeeId == followerId) {
    		return;
    	}
    	
    	if (this.hmUsers.containsKey(followerId)) {
	    	User user = this.hmUsers.get(followerId);
			List<Integer> lstFollowes = user.getFollowers();
			if (!lstFollowes.contains(followeeId)) {
				lstFollowes.add(followeeId);
			}
    	}
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	
    	if (followeeId == followerId) {
    		return;
    	}
    	
    	if (this.hmUsers.containsKey(followerId)) {
	    	User user = this.hmUsers.get(followerId);
			List<Integer> lstFollowes = user.getFollowers();
			
            int index = -1;
            for (int i = 0; i < lstFollowes.size(); i++) {
            	if (lstFollowes.get(i).equals(followeeId)) {
            		index = i;
            	}
            }
            if (index != -1)
            	lstFollowes.remove(index);
    	}

    }
}
