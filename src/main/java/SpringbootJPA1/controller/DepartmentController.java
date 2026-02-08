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

import SpringbootJPA1.dto.CreateDepartmentRequestDTO;
import SpringbootJPA1.dto.DepartmentResponseDTO;
import SpringbootJPA1.service.DepartmentService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentService serv;
	
	public DepartmentController(DepartmentService serv) {
		this.serv = serv;
	}
	
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody CreateDepartmentRequestDTO dto) {
		DepartmentResponseDTO response = serv.createDepartment(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartment() {
		List<DepartmentResponseDTO> response = serv.getAllDepartment();
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> deleteDepartment(@PathVariable int id) {
		DepartmentResponseDTO response = serv.deleteDepartment(id);
		return ResponseEntity.ok(response);
	}
}
