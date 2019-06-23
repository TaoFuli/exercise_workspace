package com.tfl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tfl.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public Item getOne() {
		return new Item(1001,"苹果",15.5,"很好吃");
	}

	@Override
	public List<Item> getAll() {
		List<Item> list=new ArrayList<>();
		list.add(new Item(1001,"苹果",18.5,"很好吃"));
		list.add(new Item(1001,"橘子",1.5,"真好吃"));
		list.add(new Item(1001,"香蕉",16.5,"很好吃"));
		list.add(new Item(1001,"葡萄",10.5,"很甜"));
		return list;
	}

}
