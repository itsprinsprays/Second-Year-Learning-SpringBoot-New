package SpringbootJPA1.mapper;

import org.springframework.stereotype.Component;

import SpringbootJPA1.dto.DepartmentResponseDTO;
import SpringbootJPA1.entity.Department;

@Component
public class DepartmentMapper {
	
	public DepartmentMapper() {}
	
	public static DepartmentResponseDTO createResponse(Department department) {
		DepartmentResponseDTO res = new DepartmentResponseDTO();
		res.setDepartmentID(department.getDepartmentID());
		res.setDepartmentName(department.getDepartmentName());
		res.setStatusMessage("Department is Created with ID of " + department.getDepartmentID());
		return res;
	}

}
