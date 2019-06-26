package com.igeek.app.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Region 
{
	private int id;
	private String name;
	private int parent_id;

}
