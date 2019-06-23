package com.tfl.pojo;

public class QueryVo {
	private User user;

	public QueryVo() {
		super();
	}

	public QueryVo(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "QueryVo [user=" + user + "]";
	}
}
