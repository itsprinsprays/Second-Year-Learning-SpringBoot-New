package SpringbootJPA1.service;

import org.springframework.stereotype.Service;

import SpringbootJPA1.dto.CreateDepartmentRequestDTO;
import SpringbootJPA1.dto.DepartmentResponseDTO;
import SpringbootJPA1.entity.Department;
import SpringbootJPA1.exception.DepartmentIDExistingException;
import SpringbootJPA1.mapper.DepartmentMapper;
import SpringbootJPA1.repository.DepartmentRepository;
import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	
	private final DepartmentRepository deptRepo;
	
	public DepartmentService(DepartmentRepository deptRepo) {
		this.deptRepo = deptRepo;
	}
	
	@Transactional
	public DepartmentResponseDTO createDepartment(CreateDepartmentRequestDTO dto) {
		if(deptRepo.existsById(dto.getDepartmentID()))
			throw new DepartmentIDExistingException(dto.getDepartmentID() + " is already existing");
		
		Department department = new Department();
		department.setDepartmentID(dto.getDepartmentID());
		department.setDepartmentName(dto.getDepartmentName());
		
		deptRepo.save(department);
		
		return DepartmentMapper.createResponse(department);

	}
	
}
