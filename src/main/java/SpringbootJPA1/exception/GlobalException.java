package SpringbootJPA1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	//EMPLOYEE EXCEPTIONS
	
	@ExceptionHandler(ContactNumberExistingException.class)
	public ResponseEntity<ErrorResponse> IDExistingException(ContactNumberExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(EmployeeIDNotExistingException.class)
	public ResponseEntity<ErrorResponse> empdIDNotExisting(EmployeeIDNotExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//DEPARTMENT EXCEPTIONS 
	
	@ExceptionHandler(DepartmentIDNotFoundException.class)
	public ResponseEntity<ErrorResponse> DeptNotExisting(DepartmentIDNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DepartmentIDExistingException.class)
	public ResponseEntity<ErrorResponse> deptExistingException(DepartmentIDExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

}