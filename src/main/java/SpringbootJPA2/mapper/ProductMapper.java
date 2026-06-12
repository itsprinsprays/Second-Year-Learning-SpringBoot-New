package SpringbootJPA2.mapper;

import org.springframework.stereotype.Component;

import SpringbootJPA2.dto.CreateProductResponseDTO;
import SpringbootJPA2.entity.Product;

@Component
public class ProductMapper {
	
	public ProductMapper() { }
	
	public static CreateProductResponseDTO createResponse(Product product, String message) {
		CreateProductResponseDTO dto = new CreateProductResponseDTO();
		
		dto.setProductName(product.getProductName());
		dto.setDescription(product.getDescription());
		dto.setStockQuantity(product.getStockQuantity());
		dto.setUnit(product.getUnit());
		System.out.print(message);
		return dto;
	}

}
