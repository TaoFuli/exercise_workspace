package com.tfl.pojo;

import java.util.List;

public class Paging<T> {
	private int pageCount;
	private int rowsCount;
	private int pageSize;
	private int currPage;
	private List<T> data;
	public Paging() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paging( int pageSize, int currPage) {
		this.pageSize = pageSize;
		this.currPage = currPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paging [pageCount=" + pageCount + ", rowsCount=" + rowsCount + ", pageSize=" + pageSize + ", currPage="
				+ currPage + ", data=" + data + "]";
	}
	
}
