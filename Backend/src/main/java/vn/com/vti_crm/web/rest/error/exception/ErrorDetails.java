package vn.com.vti_crm.web.rest.error.exception;

import java.util.Date;

/**
 * This class is ErrorDetails.
 * 
 * @Description: .
 * @author: Manhnh0903
 * @create_date: 2020/09/04
 * @version: 1.0
 * @modifer: Manhnh0903
 * @modifer_date: 2020/09/04
 */
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}