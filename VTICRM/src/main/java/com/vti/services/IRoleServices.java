package com.vti.services;

import com.vti.entity.Role;

public interface IRoleServices {
	public void addRole(Role role);
	
	public Role findByroleId(short roleId);
	}
