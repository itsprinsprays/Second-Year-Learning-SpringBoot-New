package SpringbootJDBC2.exception;

public class BookIDNotFoundException extends RuntimeException {

	public BookIDNotFoundException(String message) {
		super(message);
	}
}
