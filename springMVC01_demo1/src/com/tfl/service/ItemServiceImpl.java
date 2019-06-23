package com.tfl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tfl.pojo.Item;

/**
 * 业务实现类
 * @author cp
 *
 */

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public List<Item> findAll() {
		List<Item> list=new ArrayList<>();
		 list.add(new Item(1, "1 华为 荣耀 8", 2399, new Date(), "质量好！1"));
		 list.add(new Item(2, "2 华为 P20", 3000, new Date(), "质量好！2"));
		 list.add(new Item(3, "3 华为 荣耀 9", 2399, new Date(), "质量好！3"));
		 list.add(new Item(4, "4 华为 荣耀 10", 2399, new Date(), "质量好！4"));
		 list.add(new Item(5, "5 华为 畅想 8", 2399, new Date(), "质量好！5"));
		 list.add(new Item(6, "6 华为 怀念 8", 2399, new Date(), "质量好！6"));
		return list;
	}

}
