package com.vti.dto;

import java.util.Date;

import com.vti.entity.User;

import lombok.Getter;

@Getter
public class TeamDto {

	private int id;

	private String name;

//	private User leader;

	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public TeamDto(int id, String name, User leader, Date createDate) {
		this.id = id;
		this.name = name;
//		this.leader = leader;
		this.createDate = createDate;
	}

	public TeamDto() {
	}

	@Override
	public String toString() {
		return "TeamDto [id=" + id + ", name=" + name + ", createDate=" + createDate + "]";
	}

}
