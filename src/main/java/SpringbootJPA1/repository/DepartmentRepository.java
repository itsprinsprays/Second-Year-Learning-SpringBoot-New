package SpringbootJPA1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringbootJPA1.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
