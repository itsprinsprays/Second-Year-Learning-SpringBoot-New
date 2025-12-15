package SpringbootJPA.exception;

public class SIDExistingException extends RuntimeException{

	public SIDExistingException(String message) {
		super(message);
	}
}
