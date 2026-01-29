package SpringbootJPA1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	private int DID;
	
	@Column(nullable = false)
	private String departmentName;
	
	public Department() {}
	
	public int getDID() {
		return DID;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDID(int DID) {
		this.DID = DID;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
