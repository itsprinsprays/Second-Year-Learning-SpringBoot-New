package SpringbootJDBC2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(BookIDExistingException.class)
	public ResponseEntity<ErrorResponse> BIDExisting(BookIDExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(BookIDNotFoundException.class)
	public ResponseEntity<ErrorResponse> BIDNotExisting(BookIDNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
