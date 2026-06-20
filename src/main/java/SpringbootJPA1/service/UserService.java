package SpringbootJPA1.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SpringbootJPA1.dto.CreateAccountRequestDTO;
import SpringbootJPA1.dto.CreateAccountResponseDTO;
import SpringbootJPA1.entity.Employee;
import SpringbootJPA1.entity.User;
import SpringbootJPA1.repository.EmployeeRepository;
import SpringbootJPA1.repository.UserRepository;
import SpringbootJPA1.exception.DuplicateResourceException;
import SpringbootJPA1.exception.ResourceNotFoundException;
import SpringbootJPA1.mapper.UserMapper;

@Service
public class UserService {

	private final UserRepository urepo;
	private final EmployeeRepository erepo;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository urepo, EmployeeRepository erepo, PasswordEncoder passwordEncoder) {
		this.urepo = urepo;
		this.erepo = erepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public CreateAccountResponseDTO registerUser(CreateAccountRequestDTO dto) {
		
		
		if(urepo.existsByUsername(dto.getUsername()))
			throw new DuplicateResourceException("Username is existing");
		
		Employee employee = erepo.findByEID(dto.getEmployee_Id())
				.orElseThrow(() -> new ResourceNotFoundException("Employee Id is not existing"));
		
		if(!employee.getName().equalsIgnoreCase(dto.getUsername()))
			throw new ResourceNotFoundException("Username does not match the selected employee name");
		
		User user = new User();
		
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		user.setEmployee(employee);
		
		urepo.save(user);
		
		return UserMapper.createResponse(user, "Created Succesfully");
	}
	
}
