package com.tfl.pojo;

import java.util.List;

public class QueryVo {
	private User user;
	private List<Integer> ids;
	private List<User> userlist;
	public QueryVo() {
	}
	public QueryVo(User user, List<Integer> ids, List<User> userlist) {
		super();
		this.user = user;
		this.ids = ids;
		this.userlist = userlist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	@Override
	public String toString() {
		return "QueryVo [user=" + user + ", ids=" + ids + ", userlist=" + userlist + "]";
	}
	
}
