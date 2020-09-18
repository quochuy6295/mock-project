package vn.com.vti_crm.web.rest;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.helper.StudentHelper;
import vn.com.vti_crm.message.ResponseMessage;
import vn.com.vti_crm.service.StudentService;
import vn.com.vti_crm.domain.Student;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class StudentResource {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStudent() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@PostMapping("/students/load")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (StudentHelper.hasCSVFormat(file)) {
			try {
				studentService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	@GetMapping("/students/filter")
	public ResponseEntity<?> getAllStudents(@RequestParam(required = false) String search) throws ParseException {
		List<Student> entities = studentService.getAllStudents(search);
		return new ResponseEntity<List<Student>>(entities, HttpStatus.OK);
	}
}
