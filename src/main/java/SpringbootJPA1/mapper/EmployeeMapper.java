package SpringbootJPA1.mapper;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeMapper() {}


    public static EmployeeResponseDTO toResponse(Employee employee, String message) {
    			EmployeeResponseDTO dto = new EmployeeResponseDTO();
    			dto.setEID(employee.getEID());
    			dto.setDeptId(employee.getDepartment().getDID());
    			dto.setName(employee.getName());
    			dto.setContactNumber(employee.getContactNumber());
    			dto.setAge(employee.getAge());
    			dto.setDepartmentName(employee.getDepartment().getDepartmentName());
    			dto.setStatusMessage(message);
    			return dto;
    }
    
    public static List<EmployeeResponseDTO> allEmployeeResponse(Employee employee, String message) {
    		List<EmployeeResponseDTO> dto = new ArrayList<>();
    		dto.setName("");
    }
}
