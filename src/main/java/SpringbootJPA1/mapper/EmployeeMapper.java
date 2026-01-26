package SpringbootJPA1.mapper;

import SpringbootJPA1.dto.EmployeeRequestDTO;
import SpringbootJPA1.dto.EmployeeResponseDTO;
import SpringbootJPA1.entity.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {}

    public static Employee toEntity(EmployeeRequestDTO dto) {
        return new Employee(
                dto.getName(),
                dto.getAge(),
                dto.getContactNumber()
        );
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
