package vn.com.vti_crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.csv_student_helper.CSVStudentHelper;
import vn.com.vti_crm.service.StudentService;
import vn.com.vti_crm.web.rest.error.exception.ResponseDetails;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/csv")
public class CSVStudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students/load")
	public ResponseEntity<ResponseDetails> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVStudentHelper.hasCSVFormat(file)) {
			try {
				studentService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseDetails(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDetails(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDetails(message));
	}
}
