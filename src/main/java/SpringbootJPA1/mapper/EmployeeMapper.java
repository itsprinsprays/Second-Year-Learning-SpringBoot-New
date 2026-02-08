package SpringbootJPA1.mapper;



import java.util.List;

import org.springframework.stereotype.Component;

import SpringbootJPA1.dto.DeleteEmployeeResponseDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeMapper() {}

    public static EmployeeResponseDTO toResponse(Employee employee, String message) {
    			EmployeeResponseDTO dto = new EmployeeResponseDTO();
    			dto.setEID(employee.getEID());
    			dto.setDeptId(employee.getDepartment().getDepartmentID());
    			dto.setName(employee.getName());
    			dto.setContactNumber(employee.getContactNumber());
    			dto.setAge(employee.getAge());
    			dto.setDepartmentName(employee.getDepartment().getDepartmentName());
    			dto.setStatusMessage("Added Succesfully");
    			return dto;
    }
    
    
//    public static List<EmployeeResponseDTO> allEmployeeResponse(List<Employee> employee) {
//    	
//    		List<EmployeeResponseDTO> dtoList = new ArrayList<>();
//    		
//    		for(Employee employ : employee) {
//    		
//    		EmployeeResponseDTO dto = new EmployeeResponseDTO();
//    		dto.setEID(employ.getEID());
//    		dto.setDeptId(employ.getDepartment().getDID());
//    		dto.setName(employ.getName());
//			dto.setContactNumber(employ.getContactNumber());
//			dto.setAge(employ.getAge());
//			dto.setDepartmentName(employ.getDepartment().getDepartmentName());
//
//			
//			dtoList.add(dto);
//         }
//			return dtoList;
//    }
    
    public static List<EmployeeResponseDTO> getAllEmployee(List<Employee> employee) {
    	    			return employee.stream()
    					.map(emp -> EmployeeMapper.toResponse(emp, "all employee"))
    					.toList();
    }
    
    
    public static EmployeeResponseDTO updateResponse(Employee employee) {
    	EmployeeResponseDTO dto = new EmployeeResponseDTO();
    	
    	dto.setEID(employee.getEID());
    	dto.setName(employee.getName());
    	dto.setAge(employee.getAge());
    	dto.setContactNumber(employee.getContactNumber());
    	dto.setDeptId(employee.getDepartment().getDepartmentID());
    	dto.setDepartmentName(employee.getDepartment().getDepartmentName());
    	dto.setStatusMessage("Update Succesfully");
    	return dto;
    }
    
    public static DeleteEmployeeResponseDTO deleteResponse(Employee employee) {
    	DeleteEmployeeResponseDTO dto = new DeleteEmployeeResponseDTO();
    	dto.setName(employee.getName());
    	dto.setEID(employee.getEID());
    	dto.setStatusMessage(employee.getEID() + " is deleted");
    	return dto;
    }  
    
}
