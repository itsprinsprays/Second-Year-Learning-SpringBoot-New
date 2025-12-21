package SpringbootJPA1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(nullable = false)
	private String department;
	
	@Column(nullable = false, unique = true)
	private int contactNumber;
	
	public Employee(String name, int age, String department, int contactNumber) {
		this.name = name;
		this.age = age;
		this.department = department;
		this.contactNumber = contactNumber;
	}
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getDepartment() { return department; }
	public int getContactNumber() { return contactNumber; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setDepartment(String department) { this.department = department; }
	public void setContactNumber(int contactNumber) { this.contactNumber = contactNumber; }
}
