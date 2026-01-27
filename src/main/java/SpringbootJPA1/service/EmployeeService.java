package SpringbootJPA1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;
import SpringbootJPA1.exception.ContactNumberExistingException;
import SpringbootJPA1.mapper.EmployeeMapper;
import SpringbootJPA1.repository.DepartmentRepository;
import SpringbootJPA1.repository.EmployeeRepository;
import SpringbootJPA1.entity.*;

@Service
public class EmployeeService {
	
	private final EmployeeRepository empRepo;
	private final DepartmentRepository deptRepo;
	EmployeeMapper employeeMapper;
	
	public EmployeeService(EmployeeRepository empRepo, DepartmentRepository deptRepo, EmployeeMapper employeeMapper) {
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
		this.employeeMapper = employeeMapper;
	}
	
	@Transactional
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		if(empRepo.existsByContactNumber(dto.getContactNumber())) {
			throw new ContactNumberExistingException("Contact Number is the same");
		}
		
		
			Department dept = deptRepo.findById(dto.getDeptID())
			    .orElseThrow(() -> new RuntimeException("Department not found"));

			Employee emp = new Employee();
			emp.setName(dto.getName());
			emp.setAge(dto.getAge());
			emp.setContactNumber(dto.getContactNumber());
		    emp.setDepartment(dept); // <--- important!
		    
			Employee employee = employeeMapper.toEntity(dto);
			employee.setDepartment(dept);
			employee = empRepo.save(employee);

			empRepo.save(emp);
		
	     return EmployeeMapper.toResponse(employee,"Employee successfully registered!"  );
	}
	

}
