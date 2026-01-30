package SpringbootJPA1.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","age","contactNumber","deptID","departmentName","statusMessage"})
public class EmployeeResponseDTO {
	
	private int EID;
	private String name;
	private int age;
	private String contactNumber;
	private int deptId;
	private String statusMessage;
	private String departmentName;

	
	public EmployeeResponseDTO() { }
	
	public int getEID() { return EID; }
	public String getName(){ return name; }
	public int getAge() { return age; }
	public String getContactNumber() { return contactNumber; }
	public int getDeptId() { return deptId; }
    public String getStatusMessage() { return statusMessage;}
    public String getDepartmentName() { return departmentName;}

    public void setEID(int EID) { this.EID = EID; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setDeptId(int deptId) { this.deptId = deptId; }
    public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }



}
