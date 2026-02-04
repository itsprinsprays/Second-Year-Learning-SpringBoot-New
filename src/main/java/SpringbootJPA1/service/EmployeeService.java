package SpringbootJPA1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;
import SpringbootJPA1.exception.ContactNumberExistingException;
import SpringbootJPA1.exception.DepartmentNotFoundException;
import SpringbootJPA1.mapper.EmployeeMapper;
import SpringbootJPA1.repository.DepartmentRepository;
import SpringbootJPA1.repository.EmployeeRepository;
import SpringbootJPA1.entity.*;

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
		if(empRepo.existsByContactNumber(dto.getContactNumber())) {
			throw new ContactNumberExistingException(dto.getContactNumber() + " Contact Number is existing");
		}
		
			Department dept = deptRepo.findById(dto.getDeptId())
			    .orElseThrow(() -> new DepartmentNotFoundException(dto.getDeptId() + " Department not found"));

			Employee emp = new Employee();
			emp.setName(dto.getName());
			emp.setAge(dto.getAge());
			emp.setContactNumber(dto.getContactNumber());
		    emp.setDepartment(dept); // <--- important!
		    
			empRepo.save(emp);
		
			return EmployeeMapper.toResponse(emp, "Added Succesfully");
	     
	}
	
	public List<EmployeeResponseDTO> getAllEmployee() {
			List<Employee> employee = empRepo.findAll();
			
			return EmployeeMapper.allEmployeeResponse(employee);
			
	}

}
