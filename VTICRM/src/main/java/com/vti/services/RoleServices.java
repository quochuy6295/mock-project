package com.vti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Role;
import com.vti.repository.IRoleRepository;

@Service
public class RoleServices implements IRoleServices {

	@Autowired
	IRoleRepository repository;

	public void addRole(Role role) {
		repository.save(role);
	}

	public Role findByroleId(short roleId) {
		return repository.findByroleId(roleId);
	}

}
