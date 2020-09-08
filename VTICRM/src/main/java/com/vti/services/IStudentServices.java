package com.vti.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.Student;

public interface IStudentServices {
	
	public void save(MultipartFile file);
	
	public ByteArrayInputStream load();
	
	public List<Student> getAllTutorials();
}
