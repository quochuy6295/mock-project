package vn.com.vti_crm.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vti_crm.domain.Student;
import vn.com.vti_crm.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class StudentResource {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStudents() {
		try {
			List<Student> students = studentService.getAllStudent();

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}