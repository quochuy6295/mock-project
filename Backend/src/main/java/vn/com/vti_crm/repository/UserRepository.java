package vn.com.vti_crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.vti_crm.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findUserById(int id);

	public User findUserByEmail(String email);
}
