package vn.com.vti_crm.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.domain.Student;
import vn.com.vti_crm.helper.StudentHelper;
import vn.com.vti_crm.repository.StudentRepository;
import vn.com.vti_crm.service.StudentService;
import vn.com.vti_crm.specification.StudentSpecificationBuilder;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	public void save(MultipartFile file) {
		try {
			List<Student> students = StudentHelper.csvToStudent(file.getInputStream());
			repository.saveAll(students);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

//	public Student store(MultipartFile file) throws IOException {
//	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	    Student student = new Student(fileName, file.getContentType(), file.getBytes());
//	    return repository.save(student);
//	  }

	public ByteArrayInputStream load() {
		List<Student> students = repository.findAll();

		ByteArrayInputStream in = StudentHelper.studentToCSV(students);
		return in;
	}

	public List<Student> getAllStudents(String search) throws ParseException {

		StudentSpecificationBuilder<Student> specificationbuilder = new StudentSpecificationBuilder<Student>(search);

		return repository.findAll(specificationbuilder.build());
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public void createStudent(Student student) {
		repository.save(student);
	}

	public void deleteStudent(int id) {
		repository.deleteById(id);
	}

	public void updateStudent(Student student) {
		repository.save(student);

	}
}
