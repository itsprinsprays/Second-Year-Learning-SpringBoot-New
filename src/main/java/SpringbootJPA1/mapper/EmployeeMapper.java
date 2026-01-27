package SpringbootJPA1.mapper;

import org.springframework.stereotype.Component;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeMapper() {}

    public Employee toEntity(EmployeeRequestDTO dto) {
        	Employee employee = new Employee();
        	employee.setName(dto.getName());
        	employee.setAge(dto.getAge());
        	employee.setContactNumber(dto.getContactNumber());
        	
        	return employee;
    }

    public static EmployeeResponseDTO toResponse(Employee student, String message) {
        return new EmployeeResponseDTO(
                student.getName(),
                student.getAge(),
                student.getContactNumber(),
                message
        );
    }
}
