package SpringbootJPA1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;
import SpringbootJPA1.exception.ContactNumberExistingException;
import SpringbootJPA1.repository.DepartmentRepository;
import SpringbootJPA1.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository empRepo;
	private final DepartmentRepository deptRepo;
	
	public EmployeeService(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
	}
	
	@Transactional
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		Department dept = deptRepo.findById(dto.get)
		
		return repo.save(employee);
	}
	

}
