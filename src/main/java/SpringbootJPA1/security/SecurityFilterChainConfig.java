package SpringbootJPA1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityFilterChainConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public SecurityFilterChainConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth 
						
						.requestMatchers(HttpMethod.POST, "/api/user/register").permitAll()
						
						)
				.addFilter(jwtAuthenticationFilter)
				.build();
	}

}
