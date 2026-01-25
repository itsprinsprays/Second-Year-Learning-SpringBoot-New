package SpringbootJPA1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringbootJPA1.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
