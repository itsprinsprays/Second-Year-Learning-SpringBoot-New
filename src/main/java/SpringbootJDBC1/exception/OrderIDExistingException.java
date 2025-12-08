package SpringbootJDBC1.exception;

public class OrderIDExistingException extends RuntimeException{

	
	public OrderIDExistingException(String message) {
		super(message);
	}
}
