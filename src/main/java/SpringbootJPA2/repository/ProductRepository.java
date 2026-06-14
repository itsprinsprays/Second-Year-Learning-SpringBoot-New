package SpringbootJPA2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringbootJPA2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByProductName(String name);
	boolean existsByProductName(String name);
}
