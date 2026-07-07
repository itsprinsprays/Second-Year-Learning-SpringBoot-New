package SpringbootJPA3.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private int status;
	private String message;
	private LocalDateTime timestamps;
	
	public ErrorResponse(String message, int status) {
		this.status = status;
		this.message = message;
		this.timestamps = LocalDateTime.now();
	}
	
	public int getStatus() { return status; }
	public String getMessage() { return message; }
	public LocalDateTime timestamps() { return timestamps; }
	
	public void setStatus(int status) { this.status = status; }
	public void setMessage(String message) { this.message = message; }
	
}
