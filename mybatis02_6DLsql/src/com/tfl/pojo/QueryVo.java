package com.tfl.pojo;

import java.util.List;

public class QueryVo<T> {
	private User user;
	private List<T> ids;
	public QueryVo(List<T> ids) {
		super();
		this.ids = ids;
	}
	public QueryVo(User user) {
		super();
		this.user = user;
	}
	public QueryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<T> getIds() {
		return ids;
	}
	public void setIds(List<T> ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "QueryVo [user=" + user + ", ids=" + ids + "]";
	}
	
}
