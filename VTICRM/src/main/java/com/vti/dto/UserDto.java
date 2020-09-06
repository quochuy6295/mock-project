package com.vti.dto;

import com.vti.entity.User;

public class UserDto {

	private String userName;

	private String fullName;

	private String roleName;

	private String password;

	private String firstName;

	private String lastName;

	public UserDto() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User toEntity() {
		return new User(userName, password, firstName, lastName);
	}
}
