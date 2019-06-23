package com.tfl.pojo;

import java.util.Date;


public class Message {
	private int id;
	private User author;
	private Date publishTime;
	private String  context;
	
	private int authorId;
	
	
	public Message() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", author=" + author + ", publishTime=" + publishTime + ", context=" + context
				+ "]";
	}
	
}
