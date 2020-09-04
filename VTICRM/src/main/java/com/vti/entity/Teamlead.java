package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Teamlead", catalog = "vtiCRM")
@PrimaryKeyJoinColumn(name = "UserId")
public class Teamlead extends User implements Serializable {

	@Column(name = "Permission")
	private String Permission;

	public String getPermission() {
		return Permission;
	}

	public Teamlead() {
		super();
	}

	public void setPermission(String permission) {
		Permission = permission;
	}

}
