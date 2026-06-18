package SpringbootJPA1.entity;


import SpringbootJPA1.entity.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long user_Id;
	
	@Column(nullable = false)
	public String username;
	
	@Column(nullable = false)
	public String password;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public Role role;
	
	
	@OneToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;
	
	public User() { }
	
	public long getUser_Id() { return user_Id; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public Role getRole() { return role; }
    public Employee getEmployee() { return employee; }

	
    public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setRole(Role role) { this.role = role; }
    public void setEmployee(Employee employee) { this.employee = employee; }

}
