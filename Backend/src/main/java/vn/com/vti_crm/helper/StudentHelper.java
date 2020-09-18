package vn.com.vti_crm.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import vn.com.vti_crm.domain.Student;

public class StudentHelper {

//	@Autowired
//	private Student student;

//	public String input = student.getBirthday();
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "fullName", "gender", "phone_number", "email", "birthday", "school", "address",
			"social_info", "target", "status", "history_transaction", "source" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Student> csvToStudent(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Student> students = new ArrayList<Student>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//			Integer.parseInt(csvRecord.get("id"))
			for (CSVRecord csvRecord : csvRecords) {
				Student student = new Student(csvRecord.get("fullName"), csvRecord.get("gender"),
						csvRecord.get("phone_number"), csvRecord.get("email"), csvRecord.get("birthday"),
						csvRecord.get("school"), csvRecord.get("address"), csvRecord.get("social_info"),
						csvRecord.get("target"), csvRecord.get("status"), csvRecord.get("history_transaction"),
						csvRecord.get("source"));

				students.add(student);
			}

			return students;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream studentToCSV(List<Student> students) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (Student student : students) {
				List<String> data = Arrays.asList(student.getSource(), student.getFullName(), student.getGender(),
						student.getPhonenumber(), student.getEmail(), student.getBirthday(), student.getSchool(),
						student.getAddress(), student.getSocial_info(), student.getTarget(), student.getStatus(),
						student.getHistoryTrasacition());

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

}
