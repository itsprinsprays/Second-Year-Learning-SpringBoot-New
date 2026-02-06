package SpringbootJPA1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import SpringbootJPA1.dto.CreateEmployeeRequestDTO;
import SpringbootJPA1.dto.DeleteEmployeeResponseDTO;
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
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody CreateEmployeeRequestDTO req) {
		  EmployeeResponseDTO response = serv.createEmployee(req);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);	 //.status for signals that theres new creation
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployee() {
		 return ResponseEntity.ok(serv.getAllEmployee()); //will return that something is succesfully operate
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DeleteEmployeeResponseDTO> deleteEmployee(@PathVariable int id) {
		DeleteEmployeeResponseDTO response = serv.deleteEmployee(id);
		return ResponseEntity.ok(response); 
	}
}


