package com.tfl.pojo;

import java.util.ArrayList;
import java.util.Arrays;

public class QuerVo {
	private Integer[] ids;
	ArrayList<Integer> myids;
	public QuerVo() {
	}
	public QuerVo(Integer[] ids, ArrayList<Integer> myids) {
		super();
		this.ids = ids;
		this.myids = myids;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public ArrayList<Integer> getMyids() {
		return myids;
	}
	public void setMyids(ArrayList<Integer> myids) {
		this.myids = myids;
	}
	@Override
	public String toString() {
		return "QuerVo [ids=" + Arrays.toString(ids) + ", myids=" + myids + "]";
	}
	
}
