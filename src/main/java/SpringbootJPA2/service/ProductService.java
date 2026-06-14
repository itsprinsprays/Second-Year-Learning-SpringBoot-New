package SpringbootJPA2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import SpringbootJPA2.dto.AllProductResponseDTO;
import SpringbootJPA2.dto.CreateProductRequestDTO;
import SpringbootJPA2.dto.CreateProductResponseDTO;
import SpringbootJPA2.entity.Product;
import SpringbootJPA2.mapper.ProductMapper;
import SpringbootJPA2.repository.ProductRepository;
import jakarta.transaction.Transactional;
import SpringbootJPA2.exception.DuplicateResourceException;

@Service
public class ProductService {
	
		private final ProductRepository prepo;
		
		public ProductService(ProductRepository prepo) {
			this.prepo = prepo;
		}
		
		@Transactional
		public CreateProductResponseDTO createProduct(CreateProductRequestDTO dto) {
			
			if(prepo.existsByProductName(dto.getProductName()))
				throw new DuplicateResourceException(dto.getProductName() + " is existing");
						
			Product product = new Product();
			
				
			product.setProductName(dto.getProductName());
			product.setDescription(dto.getProductName());
			product.setStockQuantity(dto.getStockQuantity());
			product.setUnit(dto.getUnit());
			
			prepo.save(product);
			
			return ProductMapper.createResponse(product);
			
		}
		
		public Page<AllProductResponseDTO> getAllProduct(Pageable pageable) {
			
			Page<Product> page = prepo.findAll(pageable);
			
			return ProductMapper.getAllProductResponse(page);
		}

}
