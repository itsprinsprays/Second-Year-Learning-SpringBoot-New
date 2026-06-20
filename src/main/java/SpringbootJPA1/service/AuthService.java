package SpringbootJPA1.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import SpringbootJPA1.dto.LoginRequestDTO;
import SpringbootJPA1.dto.LoginResponseDTO;
import SpringbootJPA1.exception.ResourceNotFoundException;
import SpringbootJPA1.mapper.UserMapper;
import SpringbootJPA1.security.JwtUtil;

@Service
public class AuthService {
	
	private AuthenticationManager authenticationManager;
	
	private JwtUtil util;
	
	public AuthService(AuthenticationManager authenticationManager, JwtUtil util) {
		this.authenticationManager = authenticationManager;
		this.util = util;
	}
	
	public LoginResponseDTO login(LoginRequestDTO dto) {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							dto.getUsername(),
							dto.getPassword()
						));
		} catch(Exception e) {
			throw new ResourceNotFoundException("Invalid Username or password");
		}
		
		String token = util.generateToken(dto.getUsername());
		
		return UserMapper.loginTokenResponse(token);
	}

}
