package SpringbootJPA1.dto;

import jakarta.validation.constraints.NotBlank;

public class DeleteEmployeeRequestDTO {
	
	@NotBlank(message = "ID must not be Blank")
	private int id;

	DeleteEmployeeRequestDTO() { }
	
	public int getID() { return id; }
	public void setID(int id) { this.id = id; }
}
