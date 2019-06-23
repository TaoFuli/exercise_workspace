package com.tfl.pojo;

import java.util.List;

public class Paging<T> {
	private int currPage;
	private int pageSize;
	private int rowsCount;
	private int pageCount;
	private List<T> data;
	public Paging() {
	}
	public Paging(int currPage, int pageSize) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paging [currPage=" + currPage + ", pageSize=" + pageSize + ", rowsCount=" + rowsCount + ", pageCount="
				+ pageCount + "]";
	}
	
	
	
}
