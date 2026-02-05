package SpringbootJPA1.exception;

public class IDNotExistingException extends RuntimeException{
	
	public IDNotExistingException(String message) {
		super(message);
	}

}
