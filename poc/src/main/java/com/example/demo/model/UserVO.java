package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.util.CustomString;

public class UserVO implements Serializable {
	
	private static final long serialVersionUID = 6340001930731156025L;
    private String username;
    private CustomString password;
    private CustomString passwordConfirm;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CustomString getPassword() {
		return password;
	}
	public void setPassword(CustomString password) {
		this.password = password;
	}
	public CustomString getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(CustomString passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
    
    
   

}
