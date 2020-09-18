package vn.com.vti_crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import vn.com.vti_crm.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student>{

	public Optional<Student> findStudentById(int id);

//	public Optional<Student> findByPhoneNumber(String phoneNumber);
}
