package SpringbootJPA1.dto;

public class DeleteEmployeeResponseDTO {
	
	private String name;
	private int eid;
	private String statusMessage;
	
//	public EmployeeDTO(String name, int eid, String statusMessage) {
//		this.name = name;
//		this.eid = eid;
//		this.statusMessage = statusMessage;
//	}
	
	public String getName() { return name; }
	public int getEID() { return eid; }
	public String getStatusMessage() { return statusMessage; }
	
	public void setName(String name) { this.name = name; }
	public void setEID(int eid) { this.eid = eid; }
	public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }

}
