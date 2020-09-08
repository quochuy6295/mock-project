package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public User findByuserName(String userName);

	public boolean existsByuserName(String userName);
}
