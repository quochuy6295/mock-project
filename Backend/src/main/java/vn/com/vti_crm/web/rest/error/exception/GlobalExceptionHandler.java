package vn.com.vti_crm.web.rest.error.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * This class is GlobalExceptionHandler. 
 * 
 * @Description: .
 * @author: Manhnh0903
 * @create_date: 2020/09/04
 * @version: 1.0
 * @modifer: Manhnh0903
 * @modifer_date: 2020/09/04
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
         ResponseDetails responseDetails = new ResponseDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(responseDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ResponseDetails responseDetails = new ResponseDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(responseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}