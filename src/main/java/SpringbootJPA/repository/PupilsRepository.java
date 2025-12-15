package SpringbootJPA.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringbootJPA.entity.Pupils;

public interface PupilsRepository extends JpaRepository<Pupils, Long>{
	
//	Optional<Pupils> findByID(Long ID);

}
