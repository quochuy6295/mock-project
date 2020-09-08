package com.vti.dto;

import com.vti.entity.enumerate.RoleName;

public class RoleDTO {

	private RoleName name;

	public RoleDTO(RoleName name) {
		this.name = name;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

}
