package SpringbootJDBC2.exception;

public class BookIDExistingException extends RuntimeException{
	
	public BookIDExistingException(String message) {
		super(message);
	}
}
