package SpringbootJPA2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringbootJPA2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
