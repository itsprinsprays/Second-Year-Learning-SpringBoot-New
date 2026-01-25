package SpringbootJPA1.exception;

public class ContactNumberExistingException extends RuntimeException{
	public ContactNumberExistingException(String message) {
		super(message);
	}

}
