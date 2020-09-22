package vn.com.vti_crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.vti_crm.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public Optional<Student> findStudentById(long id);

	public Optional<Student> findByPhoneNumber(String phoneNumber);
}
