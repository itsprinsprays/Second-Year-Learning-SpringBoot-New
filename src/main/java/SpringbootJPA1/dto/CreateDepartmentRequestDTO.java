package SpringbootJPA1.dto;

import jakarta.validation.constraints.NotNull;

public class CreateDepartmentRequestDTO {
	
	@NotNull(message = "Department ID must not be blank")
	private int departmentID;
	
	@NotNull(message = "Name must not be Null")
	private String departmentName;
	
	CreateDepartmentRequestDTO() {}
	
	public int getDepartmentID() { return departmentID; }
	public String getDepartmentName() { return departmentName; }
	
	public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
	public void setDepartmentID(int departmentID) { this.departmentID = departmentID; }

}
