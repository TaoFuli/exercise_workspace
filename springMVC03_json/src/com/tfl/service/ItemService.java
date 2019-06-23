package com.tfl.service;

import java.util.List;

import com.tfl.pojo.Item;

public interface ItemService {
	Item getOne();
	List<Item> getAll();
}
