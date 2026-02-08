package SpringbootJPA1.exception;

public class DepartmentIDNotFoundException extends RuntimeException{
	public DepartmentIDNotFoundException(String message) {
		super(message);
	}
}
