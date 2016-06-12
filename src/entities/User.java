package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private int userid;
	private String username;
	private List<Integer> lstFollowers = new ArrayList<Integer>();
	private List<Tweet> lstTweets = new ArrayList<Tweet>();
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Integer> getFollowers() {
		return lstFollowers;
	}
	public void setFollowers(List<Integer> lstFollowers) {
		this.lstFollowers = lstFollowers;
	}
	public List<Tweet> getTweets() {
		return lstTweets;
	}
	public void setTweets(List<Tweet> lstTweets) {
		this.lstTweets = lstTweets;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
