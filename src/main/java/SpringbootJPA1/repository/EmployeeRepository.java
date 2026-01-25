package SpringbootJPA1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringbootJPA1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	boolean existingContactNumber(String contactNumber);
}
