package SpringbootJPA1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {
	
	@NotBlank(message = "Name must not be Blank")
	private String name;
	
	@Min(value = 18, message = "Age must be atleast 18 years old")
	private int age;
	
	//@Size(min = 11, max = 11, message = "Contact Number Must be 11 digits") -- for String also but it can contain letters
	@Pattern(regexp = "\\d{11}", message = "Contact Number must be 11 Digits")
	private String contactNumber;
	
	private Long deptId;
	
	public EmployeeRequestDTO() {}
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getContactNumber() { return contactNumber; }
	public Long getDeptID() { return deptId; }
	
	
}
