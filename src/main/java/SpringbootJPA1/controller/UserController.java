package SpringbootJPA1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJPA1.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import SpringbootJPA1.dto.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService serv;
	
	public UserController(UserService serv) {
		this.serv = serv;
	}

	
	@PostMapping("/register")
	public ResponseEntity<CreateAccountResponseDTO> registerAccount(@RequestBody CreateAccountRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.registerUser(dto));
	}
}
