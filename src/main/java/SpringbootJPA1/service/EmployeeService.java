package SpringbootJPA1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import SpringbootJPA1.dto.CreateEmployeeRequestDTO;
import SpringbootJPA1.dto.DeleteEmployeeResponseDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;
import SpringbootJPA1.exception.ContactNumberExistingException;
import SpringbootJPA1.exception.DepartmentNotFoundException;
import SpringbootJPA1.exception.IDNotExistingException;
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
	public EmployeeResponseDTO createEmployee(CreateEmployeeRequestDTO dto) {
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
			
			return EmployeeMapper.getAllEmployee(employee);
			
	}
	
	@Transactional //used for procedural or step by step process. Will negate if the process is not finish
	public DeleteEmployeeResponseDTO deleteEmployee(int id) { //If the needed field is 1 only then @PathVariable is enought, hence z	
	    Employee employee = empRepo.findById(id)		//requestDTO is not needed since it used for multiple field attributes.
	        .orElseThrow(() -> new IDNotExistingException(id + " not found"));
	    
//	    EmployeeMapper.deleteEmployee(employee);

	    empRepo.delete(employee);

	    return EmployeeMapper.convertToDTO(employee);
	}

}
