package vn.com.vti_crm.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.csv_student_helper.CSVStudentHelper;
import vn.com.vti_crm.domain.Student;
import vn.com.vti_crm.repository.StudentRepository;
import vn.com.vti_crm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public void save(MultipartFile file) throws ParseException, IOException {
		List<Student> students = CSVStudentHelper.csvToStudents(file.getInputStream());
		for (Student student : students) {
			try {
			studentRepository.save(student);
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
