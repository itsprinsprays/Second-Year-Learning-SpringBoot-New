package SpringbootJPA.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private final String message;
	private final int status;
	private LocalDateTime time;
	
	
	public ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
		this.time = LocalDateTime.now();
	}
	
	public String getMessage() { return message; }
	public int getStatus() { return status; }
	public LocalDateTime getTime() { return  time; }

 }
