package entities;

import java.util.Date;

public class Tweet {

	private int id;
	private int userid;
	private String header;
	private String text;
	private Date creationDate;
	
	public Tweet(int id, int userid, String header, String text, Date creationDate) {
		super();
		this.id = id;
		this.userid = userid;
		this.text = text;
		this.header = header;
		this.creationDate = creationDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}
