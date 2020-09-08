package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Short>{

	Role findByroleId(short roleId);

}
