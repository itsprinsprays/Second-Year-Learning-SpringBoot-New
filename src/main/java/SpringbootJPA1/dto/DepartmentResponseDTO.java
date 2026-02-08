package SpringbootJPA1.dto;

public class DepartmentResponseDTO {

	private int departmentID;
	private String departmentName;
	private String statusMessage;
	
	public DepartmentResponseDTO() {}
	
	public int getDepartmentID() { return departmentID; }
	public String getDepartmentName() { return departmentName; }
	public String getStatusMessage() { return statusMessage; }
	
	public void setDepartmentID(int DepartmentID) { this.departmentID = DepartmentID; }
	public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
	public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }
}
