package SpringbootJPA2.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import SpringbootJPA2.Status;
import SpringbootJPA2.dto.AllProductResponseDTO;
import SpringbootJPA2.dto.CreateProductRequestDTO;
import SpringbootJPA2.dto.CreateProductResponseDTO;
import SpringbootJPA2.dto.DeleteProductResponseDTO;
import SpringbootJPA2.dto.SoftDeleteRequestDTO;
import SpringbootJPA2.entity.Product;
import SpringbootJPA2.mapper.ProductMapper;
import SpringbootJPA2.repository.ProductRepository;
import jakarta.transaction.Transactional;
import SpringbootJPA2.exception.DuplicateResourceException;
import SpringbootJPA2.exception.ResourceNotFoundException;

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
		
		@Transactional
		public AllProductResponseDTO getProductById(Long Id) {
			Product product = prepo.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException(Id + " is not existing"));
			
			return ProductMapper.getByIdResponse(product);
		}
		
		@Transactional
		public DeleteProductResponseDTO deleteProductById(Long Id) {
			Product product = prepo.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException(Id + " is not existing"));
			
			prepo.deleteById(Id);
			
			return ProductMapper.deleteResponse(product);
			
		}
		
		@Transactional
		public AllProductResponseDTO softDeleteProduct(SoftDeleteRequestDTO dto, Long Id) {
			
			Product product = prepo.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException(Id + " is not existing"));
			
			product.setStatus(dto.getStatus());
			
			prepo.save(product);
			
			return ProductMapper.getByIdResponse(product);
			
		}
		
		
		

}
