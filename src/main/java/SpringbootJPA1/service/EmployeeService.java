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
	
	public EmployeeService(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
		this.empRepo = empRepo;
		this.deptRepo = deptRepo;
	}
	
	@Transactional
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		if(empRepo.existsByContactNumber(dto.getContactNumber())) {
			throw new ContactNumberExistingException("Contact Number is the same");
		}
		
		Employee employee = EmployeeMapper.toEntity(dto);
		employee = empRepo.save(employee);
		
		Department dept = deptRepo.findById(req.getDeptId())
			    .orElseThrow(() -> new RuntimeException("Department not found"));

			Employee emp = new Employee();
			emp.setName(req.getName());
			emp.setAge(req.getAge());
			emp.setContactNumber(req.getContactNumber());
			emp.setDepartment(dept);  // <--- important!

			employeeRepository.save(emp);
		
	     return EmployeeMapper.toResponse(employee,"Employee successfully registered!"  );
	}
	

}
