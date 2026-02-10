package SpringbootJPA1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import SpringbootJPA1.dto.CreateEmployeeRequestDTO;
import SpringbootJPA1.dto.DeleteEmployeeResponseDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.dto.UpdateEmployeeRequestDTO;
import SpringbootJPA1.exception.ErrorResponse;
import SpringbootJPA1.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
	@Operation(summary = "Create a new employee")
	@ApiResponses(value = {
			@ApiResponse(
				    responseCode = "201",
				    description = "Employee created successfully",
				    content = @Content(
				        mediaType = "application/json",
				        schema = @Schema(implementation = EmployeeResponseDTO.class)
				    )
				),
			@ApiResponse(
				    responseCode = "409",
				    description = "ContactNumber is Existing",
				    content = @Content(
				        mediaType = "application/json",
				        schema = @Schema(implementation = ErrorResponse.class,
				        		   example = "{\"message\":\"ContactNumber already exists\",\"status\":409,\"timeStamps\":\"2026-02-09T21:15:00\"}")
				    ))
	})
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody CreateEmployeeRequestDTO req) {
		  EmployeeResponseDTO response = serv.createEmployee(req);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);	 //.status for signals that theres new creation
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployee() {
		 return ResponseEntity.ok(serv.getAllEmployee()); //will return that something is succesfully operate
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@Valid @RequestBody UpdateEmployeeRequestDTO req, @PathVariable int id) {
		EmployeeResponseDTO response = serv.UpdateEmployee(req, id);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DeleteEmployeeResponseDTO> deleteEmployee(@PathVariable int id) {
		DeleteEmployeeResponseDTO response = serv.deleteEmployee(id);
		return ResponseEntity.ok(response); 
	}
}


