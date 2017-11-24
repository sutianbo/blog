package com.blog.model.dto;

import java.io.Serializable;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -8678441654767693988L;
	
	private String username;
	private String password;
	
	public UserModel(String username,String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
