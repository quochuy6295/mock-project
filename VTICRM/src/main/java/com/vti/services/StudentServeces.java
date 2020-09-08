package com.vti.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.Student;
import com.vti.repository.IStudentRepository;
import com.vti.helper.CSVHelper;

@Service
public class StudentServeces implements IStudentServices{

	@Autowired
	IStudentRepository repository;

	public void save(MultipartFile file) {
		try {
			List<Student> students = CSVHelper.csvToTutorials(file.getInputStream());
			repository.saveAll(students);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public ByteArrayInputStream load() {
		List<Student> students = repository.findAll();

		ByteArrayInputStream in = CSVHelper.studentsToCSV(students);
		return in;
	}

	public List<Student> getAllTutorials() {
		return repository.findAll();
	}
}
