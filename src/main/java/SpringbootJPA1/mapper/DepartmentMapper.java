package SpringbootJPA1.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import SpringbootJPA1.dto.DepartmentResponseDTO;
import SpringbootJPA1.entity.Department;

@Component
public class DepartmentMapper {
	
	public DepartmentMapper() {}
	
	public static DepartmentResponseDTO createResponse(Department department) {
		DepartmentResponseDTO dto = new DepartmentResponseDTO();
		dto.setDepartmentID(department.getDepartmentID());
		dto.setDepartmentName(department.getDepartmentName());
		dto.setStatusMessage("Department is Created with ID of " + department.getDepartmentID());
		return dto;
	}
	
	public static List<DepartmentResponseDTO> getAllResponse(List<Department> department) {
		
		return department.stream()
				.map(dep -> DepartmentMapper.createResponse(dep))
				.toList();
	}
	
	public static DepartmentResponseDTO deleteResponse(Department department) {
		DepartmentResponseDTO dto = new DepartmentResponseDTO();
		
		dto.setDepartmentID(department.getDepartmentID());
		dto.setDepartmentName(department.getDepartmentName());
		dto.setStatusMessage(department.getDepartmentName() + " has been deleted");
		return dto;
	}

}
