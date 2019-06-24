package com.tfl.service;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.Paging;

public interface UserService {
	Paging<LeaveWord> search(int pageSize,int currPage);
}
