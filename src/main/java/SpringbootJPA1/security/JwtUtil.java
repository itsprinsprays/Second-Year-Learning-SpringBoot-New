package SpringbootJPA1.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prince.ems.exception.InvalidTokenException;
import com.prince.ems.exception.TokenExpiredException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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
		this.SECRET = Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(String username) {
		
		return Jwts.builder()
					.setSubject(username)
					.claim("type", "access")
					.setIssuedAt(new Date())
					.setExpiration(new Date(
							System.currentTimeMillis() + accessExpiration))
					.signWith(SECRET)
					.compact();
		
	}
	
	public String generateRefreshToken(String username) {
		
		return Jwts.builder()
					.setSubject(username)
					.claim("type", "refresh")
					.setIssuedAt(new Date())
					.setExpiration(new Date(
							System.currentTimeMillis() + refreshExpiration))
					.signWith(SECRET)
					.compact();
		
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(SECRET)
				.build()
				.parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			throw new TokenExpiredException("");
		} catch (JwtException | IllegalArgumentException e) {
			throw new InvalidTokenException("");
		}
	}
	
	
	
	
	
	
}
