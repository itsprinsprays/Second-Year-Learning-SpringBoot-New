package SpringbootJPA2.dto;

import SpringbootJPA2.Status;
import jakarta.validation.constraints.NotNull;

public class SoftDeleteRequestDTO {
	
	@NotNull(message = "Status is required")
	private Status status;
	
	public SoftDeleteRequestDTO() { }
	
	public Status getStatus() { return status; }
	
	public void setStatus(Status status) { this.status = status; }
	
}
