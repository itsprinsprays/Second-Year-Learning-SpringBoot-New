package SpringbootJDBC3.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//Sport Not Existing
	@ExceptionHandler(SportNotFoundException.class)
	public ResponseEntity<ErrorResponse> sportNotExisting(SportNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//Sport  Existing 
	@ExceptionHandler(SportIsExistingException.class)
	public ResponseEntity<ErrorResponse> sportExisting(SportIsExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	//Athlete Existing
	@ExceptionHandler(AthleteIsExistingException.class)
	public ResponseEntity<ErrorResponse> athleteExisting(AthleteIsExistingException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	//Athlete Not Existing
	@ExceptionHandler(AthleteNotFoundException.class)
	public ResponseEntity<ErrorResponse> athleteNotExisting(AthleteNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//Generic Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> genericHandling(Exception e) {
		ErrorResponse error = new ErrorResponse("Something went Wrong! " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
