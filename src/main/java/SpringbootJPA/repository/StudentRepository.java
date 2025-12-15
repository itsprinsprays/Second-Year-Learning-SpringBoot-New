package SpringbootJPA.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import SpringbootJPA.entity.*;

public interface StudentRepository extends JpaRepository<Pupils, Long>{
	

}
