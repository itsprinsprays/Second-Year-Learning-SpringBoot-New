package SpringbootJPA1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {
	
	private final EmployeeService serv;
	
	public EmployeeController(EmployeeService serv) {
		this.serv = serv;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO req) {
		  EmployeeResponseDTO response = serv.createEmployee(req);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);	}

}
