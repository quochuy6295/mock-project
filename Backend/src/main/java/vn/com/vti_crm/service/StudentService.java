package vn.com.vti_crm.service;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.domain.Student;

@Service
public interface StudentService {

	public void save(MultipartFile file);

	public ByteArrayInputStream load();

	public List<Student> getAllStudents();

	public void createStudent(Student student);

	public void deleteStudent(int id);

	public List<Student> getAllStudents(String search) throws ParseException;

	public void updateStudent(Student student);
}
