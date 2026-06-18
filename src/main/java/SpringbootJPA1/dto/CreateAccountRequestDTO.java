package SpringbootJPA1.dto;

import SpringbootJPA1.entity.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateAccountRequestDTO {
	
	@NotNull(message = "Username is required")
	private String username;
	
	@NotNull(message = "Password is required")
	@Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one capital letter")
	@Size(min = 5, message = "Password must be at least 5 characters")
	private String password;
	
	@NotNull(message = "Role is required")
	private Role role;
	
	@NotNull(message = "Employee ID is Required")
	private long employee_Id;
	
	public CreateAccountRequestDTO() { }
	
	// Getter and Setter for username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
    public long getEmployee_Id() {
    	return employee_Id;
    }

}
