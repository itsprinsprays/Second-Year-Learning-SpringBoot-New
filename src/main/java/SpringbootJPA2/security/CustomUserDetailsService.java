package SpringbootJPA2.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import SpringbootJPA2.entity.User;
import SpringbootJPA2.exception.ResourceNotFoundException;
import SpringbootJPA2.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository erepo;
	
	public CustomUserDetailsService(UserRepository erepo) {
		this.erepo = erepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User user = erepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username not Found"));
		
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().name())
				.build();
		
	}

}
