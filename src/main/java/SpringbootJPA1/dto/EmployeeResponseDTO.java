package SpringbootJPA1.dto;

public class EmployeeResponseDTO {
	
	private String name;
	private int age;
	private String contactNumber;
	private Long deptId;
	private String statusMessage;
	
	public EmployeeResponseDTO() { }
	
	public EmployeeResponseDTO(String name, int age, String contactNumber,String statusMessage) {
		this.name = name;
		this.age = age;
		this.contactNumber = contactNumber;
		this.statusMessage = statusMessage;
	}
	
	public String getName(){ return name; }
	public int getAge() { return age; }
	public String getContactNumber() { return contactNumber; }
	public Long getDeptId() { return deptId; }
    public String getStatusMessage() { return statusMessage;}

}
