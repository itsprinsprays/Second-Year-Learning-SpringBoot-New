package SpringbootJPA2.service;

import org.springframework.stereotype.Service;

import SpringbootJPA2.dto.CreateProductRequestDTO;
import SpringbootJPA2.dto.CreateProductResponseDTO;
import SpringbootJPA2.entity.Product;
import SpringbootJPA2.mapper.ProductMapper;
import SpringbootJPA2.repository.ProductRepository;

import SpringbootJPA2.exception.DuplicateResourceException;

@Service
public class ProductService {
	
		private final ProductRepository prepo;
		
		public ProductService(ProductRepository prepo) {
			this.prepo = prepo;
		}
		
		
		public CreateProductResponseDTO createProduct(CreateProductRequestDTO dto) {
			
			Product product = prepo.findByName(dto.getProductName())
					.orElseThrow(() -> new DuplicateResourceException(dto.getProductName() + "is existing"));
			
				
			product.setProductName(dto.getProductName());
			product.setDescription(dto.getProductName());
			product.setStockQuantity(dto.getStockQuantity());
			product.setUnit(dto.getUnit());
			
			prepo.save(product);
			
			return ProductMapper.createResponse(product, "Product Created");
			
		}

}
