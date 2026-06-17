package SpringbootJPA1.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("util")
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.accessExpiration}")
	private long accessExpiration;
	
	@Value("${jwt.refreshExpiration}")
	private long refreshExpiration;
	
	private SecretKey SECRET;
	
	@PostConstruct
	public void init() {
		this.SECRET = hmacShaKeysFor(secret.getBytes());
	}
	
}
