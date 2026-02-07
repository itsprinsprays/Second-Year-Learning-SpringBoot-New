package SpringbootJPA1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import SpringbootJPA1.dto.CreateEmployeeRequestDTO;
import SpringbootJPA1.dto.DeleteEmployeeResponseDTO ;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.dto.UpdateEmployeeRequestDTO;
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
	
	//Creating an employee
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
	
	//Getting all the employee
	public List<EmployeeResponseDTO> getAllEmployee() {
			List<Employee> employee = empRepo.findAll();
			
			return EmployeeMapper.getAllEmployee(employee);
			
	}
	
	@Transactional
	public EmployeeResponseDTO UpdateEmployee(UpdateEmployeeRequestDTO dto, int id) {
		Employee employee = empRepo.findById(id).
				orElseThrow(() -> new IDNotExistingException(id + " not found"));
		
		if(dto.getName() != null) {
			employee.setName(dto.getName());
		}
	
		if(dto.getAge() >= 18) {
			employee.setAge(dto.getAge());
		}
		
		if(dto.getContactNumber() != null) {
			employee.setContactNumber(dto.getContactNumber());
		}
		
		empRepo.save(employee);
		
		return EmployeeMapper.updateResponse(employee);
		
		
	}
	
	
	//deleting an employee using their id
	@Transactional //used for procedural or step by step process. Will negate if the process is not finish
	public DeleteEmployeeResponseDTO deleteEmployee(int id) { //If the needed field is 1 only then @PathVariable is enought, hence z	
	    Employee employee = empRepo.findById(id)		//requestDTO is not needed since it used for multiple field attributes.
	        .orElseThrow(() -> new IDNotExistingException(id + " not found"));

	    empRepo.delete(employee);

	    return EmployeeMapper.deleteResponse(employee);
	}

}
