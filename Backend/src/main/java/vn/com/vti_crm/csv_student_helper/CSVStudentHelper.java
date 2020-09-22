package vn.com.vti_crm.csv_student_helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.domain.Student;
import vn.com.vti_crm.domain.enumerate.Gender;
import vn.com.vti_crm.domain.enumerate.Source;
import vn.com.vti_crm.domain.enumerate.Status;
import vn.com.vti_crm.domain.enumerate.Target;

public class CSVStudentHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "address", "birthday", "email", "fullName", "gender", "historyTransaction",
			"phoneNumber", "school", "socialInfo", "source", "status", "target" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Student> csvToStudents(InputStream input) throws IOException {

		BufferedReader fileReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		CSVParser csvParser = new CSVParser(fileReader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		List<Student> students = new ArrayList<Student>();

		Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		for (CSVRecord csvRecord : csvRecords) {
			System.out.println(csvRecord.get("birthday"));
			try {
				Student student = new Student(csvRecord.get("fullName"), convertGender(csvRecord.get("gender")),
						csvRecord.get("phoneNumber"), csvRecord.get("email"),
						csvRecord.get("birthday").isEmpty() ? null
								: new SimpleDateFormat("dd-MM-yyyy").parse(csvRecord.get("birthday")),
						csvRecord.get("school"), csvRecord.get("address"), csvRecord.get("socialInfo"),
						convertTarget(csvRecord.get("target")), convertStatus(csvRecord.get("status")),
						csvRecord.get("historyTransaction"), convertSource(csvRecord.get("source")), new Date());

				students.add(student);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		csvParser.close();
		return students;
	}

	private static Gender convertGender(String gender) throws RuntimeException {
		if (gender == null || gender.isEmpty()) {
			throw new RuntimeException("Gender is required!");
		}

		try {
			return Gender.valueOf(gender);
		} catch (Exception e) {
			throw new RuntimeException("Gender is not valid!");
		}
	}

	private static Target convertTarget(String target) throws RuntimeException {
		if (target == null || target.isEmpty()) {
			throw new RuntimeException("Target is required!");
		}

		try {
			return Target.valueOf(target);
		} catch (Exception e) {
			throw new RuntimeException("Target is not valid!");
		}
	}

	private static Status convertStatus(String status) throws RuntimeException {
		if (status == null || status.isEmpty()) {
			throw new RuntimeException("Status is required!");
		}

		try {
			return Status.valueOf(status);
		} catch (Exception e) {
			throw new RuntimeException("Status is not valid!");
		}
	}

	private static Source convertSource(String source) throws RuntimeException {
		if (source == null || source.isEmpty()) {
			throw new RuntimeException("Source is required!");
		}

		try {
			return Source.valueOf(source);
		} catch (Exception e) {
			throw new RuntimeException("Source is not valid!");
		}
	}
}
