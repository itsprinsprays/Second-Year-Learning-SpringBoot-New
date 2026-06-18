package SpringbootJPA1.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import SpringbootJPA1.entity.User;
import SpringbootJPA1.exception.ResourceNotFoundException;
import SpringbootJPA1.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	UserRepository urepo;
	
	public CustomUserDetailsService(UserRepository urepo) {
		this.urepo = urepo;
	}
	
	public UserDetails loadUserByUsername(String username) {
		
		User user = urepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("No Username Found"));
		
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().name())
				.build();
		
	}
	
}
