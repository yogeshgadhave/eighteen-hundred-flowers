package com.eighteen.hundred.flowers.model;

public class UserPost {

	public Integer userId;
	public Integer id;
	public String title;
	public String body;
	
	
	public UserPost() {
		super();
	}
	
	public UserPost(Integer userId, Integer id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "UserPost [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
}
