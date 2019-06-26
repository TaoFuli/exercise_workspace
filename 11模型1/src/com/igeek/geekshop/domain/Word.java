package com.igeek.geekshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Word 
{
	private int id;
	private String word;
	private int user_id;

}
