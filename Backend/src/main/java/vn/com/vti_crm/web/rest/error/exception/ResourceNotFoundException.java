package vn.com.vti_crm.web.rest.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is ResourceNotFoundException.
 * 
 * @Description: .
 * @author: Manhnh0903
 * @create_date: 2020/09/04
 * @version: 1.0
 * @modifer: Manhnh0903
 * @modifer_date: 2020/09/04
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
