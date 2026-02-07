package SpringbootJPA1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public class UpdateEmployeeRequestDTO {
	
//	@Null(message = "Updating without name?")                                        //in using partial update dont use annotation since
	String name;																	//the function of partial is for optional
//	
//	@Null(message = "Updating without age?")
//	@Min(value = 18, message = "Age must be 18 and above")
	int age;
	
//	@Null(message = "Updating without contactNumber?")
//	@Size(min = 11, max = 11, message = "ContactNumber must be 11")
	String contactNumber;
	
	public UpdateEmployeeRequestDTO() { }
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getContactNumber() { return contactNumber; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

}
