package com.tfl.service;

import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public interface UserService {
	Paging<User> search(String username,int currPage,int pageSize);
}
