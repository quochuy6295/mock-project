package vn.com.vti_crm.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.domain.Student;

@Service
public interface StudentService {

	public List<Student> getAllStudent();

	public void save(MultipartFile file) throws ParseException, IOException;

}
