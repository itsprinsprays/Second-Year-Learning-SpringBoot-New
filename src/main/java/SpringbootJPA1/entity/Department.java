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
	private int departmentID;
	
	@Column(nullable = false)
	private String departmentName;
	
	public Department() {}
	
	public int getDepartmentID() {
		return departmentID;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
