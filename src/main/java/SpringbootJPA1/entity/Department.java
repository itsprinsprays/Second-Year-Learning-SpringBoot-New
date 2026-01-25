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
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "dept")
	@TableGenerator(name = "dept", initialValue = 100, allocationSize = 1)
	private int DID;
	
	@Column(nullable = false)
	private String departmentName;
	
	public Department(int DID, String departmentName) {
		this.DID = DID;
		this.departmentName = departmentName;
	}
	
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
