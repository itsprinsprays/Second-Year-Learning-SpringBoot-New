package SpringbootJPA2.entity;

import SpringbootJPA2.entity.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;



@Entity
@Table(name = "Security_User")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_Id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private String password;
	
	private Role role;
	
	public User() { }
	
	public Long getProduct_id() { return product_Id; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public Role getRole() { return role; }
	
	public void setProduct_Id(Long product_Id) { this.product_Id = product_Id; }
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setRole(Role role) { this.role = role; }
	
	

}
