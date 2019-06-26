package com.igeek.app.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageBean<T>
{
	List<T> list;
	
	// 当前第几页 
	int page;
	// 总页数
	int pageAllCount;
	// 每页数量
	int countPerPage;
	// 分页开始
	int start;
	int end;

}
