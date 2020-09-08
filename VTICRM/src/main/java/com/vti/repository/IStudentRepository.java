package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
