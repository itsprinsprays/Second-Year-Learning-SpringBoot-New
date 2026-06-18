package SpringbootJPA1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringbootJPA1.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	boolean existsByContactNumber(String contactNumber);
	Optional<Employee> findByEmployeeId(long Id);
}
