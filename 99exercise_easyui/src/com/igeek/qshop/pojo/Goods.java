package com.igeek.qshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Goods 
{
	private int id;
	private String name;
	private float price;
	private String image;
	private String description;
	private int category_id;
}
