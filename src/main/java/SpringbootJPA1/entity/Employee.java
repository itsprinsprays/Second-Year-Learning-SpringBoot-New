package SpringbootJPA1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EID;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false, unique = true)
	private String contactNumber;
	
	@ManyToOne
	@JoinColumn(name = "dept_Id", nullable = false)
	private Department department;
	
	public Employee() {}
	
	public Employee(String name, int age, String contactNumber, Department department) {
		this.name = name;
		this.age = age;
		this.contactNumber = contactNumber;
		this.department = department;
	}
	
	//Getters
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getContactNumber() { return contactNumber; }
	public int getEID() { return EID; }
	public Department getDepartment() { return department; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
	public void setDepartment(Department department) { this.department = department; }
}
