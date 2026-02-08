package SpringbootJPA1.exception;

public class DepartmentIDExistingException extends RuntimeException{
	
	public DepartmentIDExistingException(String message) {
		super(message);
	}

}
