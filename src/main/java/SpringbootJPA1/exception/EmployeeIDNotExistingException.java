package SpringbootJPA1.exception;

public class EmployeeIDNotExistingException extends RuntimeException{
	
	public EmployeeIDNotExistingException(String message) {
		super(message);
	}

}
