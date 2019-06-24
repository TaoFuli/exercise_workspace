package com.tfl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User{
	private int id;
	private String username;
	private String loginName;
	private String password;
	private String sex;
	private String birthday;
	private String email;
}