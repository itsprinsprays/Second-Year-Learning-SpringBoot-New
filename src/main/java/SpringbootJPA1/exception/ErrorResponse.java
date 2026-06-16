package SpringbootJPA1.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private String message;
	private int status;
	private LocalDateTime timeStamps;
	
	public ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
		this.timeStamps = LocalDateTime.now();
	}
	
	public String getMessage() { return message; }
	public int getStatus() { return status; }
	public LocalDateTime getTimeStamps() { return timeStamps; }

}
