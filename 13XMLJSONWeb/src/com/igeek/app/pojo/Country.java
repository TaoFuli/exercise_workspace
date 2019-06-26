package com.igeek.app.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {

	// 编码
	private String code;
	// 国家的名字
	private String name;
	// 首都城市的编号
	private int capital;
}
