package com.tfl.service;

public interface UserService {
	public int search(int id);
	public boolean remove(int id);
	public boolean edit(int id,String name);
}
