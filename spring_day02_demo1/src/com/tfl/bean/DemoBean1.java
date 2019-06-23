package com.tfl.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DemoBean1 {
	private String []arrays;
	private List<Integer> list;
	private Set<Boolean> set;
	public void setArrays(String[] arrays) {
		this.arrays = arrays;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public void setSet(Set<Boolean> set) {
		this.set = set;
	}
	public void printArray() {
		System.out.println(Arrays.toString(arrays));
	}
	public void printList() {
		System.out.println(list.toArray());
	}
	public void printSet() {
		System.out.println(Arrays.toString(set.toArray()));
	}
	
}
