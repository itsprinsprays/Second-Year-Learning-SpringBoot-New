package SpringbootJPA2.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import SpringbootJPA2.dto.AllProductResponseDTO;
import SpringbootJPA2.dto.CreateProductResponseDTO;
import SpringbootJPA2.dto.DeleteProductResponseDTO;
import SpringbootJPA2.dto.SoftDeleteRequestDTO;
import SpringbootJPA2.entity.Product;

@Component
public class ProductMapper {
	
	public ProductMapper() { }
	
	public static CreateProductResponseDTO createResponse(Product product) {
		CreateProductResponseDTO dto = new CreateProductResponseDTO();
		
		dto.setProductName(product.getProductName());
		dto.setDescription(product.getDescription());
		dto.setStockQuantity(product.getStockQuantity());
		dto.setUnit(product.getUnit());
		return dto;
	}
	
	public static Page<AllProductResponseDTO> getAllProductResponse(Page<Product> product) {
		return product.map(prod -> {
			AllProductResponseDTO dto = new AllProductResponseDTO();
			dto.setProduct_Id(prod.getProduct_Id());
			dto.setCreated_At(prod.getCreated_At());
			dto.setProductName(prod.getProductName());
			dto.setStockQuantity(prod.getStockQuantity());
			dto.setDescription(prod.getDescription());
			dto.setUnit(prod.getUnit());
			dto.setStatus(prod.getStatus());
			return dto;
		});
	}
	
	public static AllProductResponseDTO getByIdResponse(Product product) {
			AllProductResponseDTO dto = new AllProductResponseDTO();
			dto.setProduct_Id(product.getProduct_Id());
			dto.setCreated_At(product.getCreated_At());
			dto.setProductName(product.getProductName());
			dto.setStockQuantity(product.getStockQuantity());
			dto.setDescription(product.getDescription());
			dto.setUnit(product.getUnit());
			dto.setStatus(product.getStatus());
			return dto;
	}
	
	public static DeleteProductResponseDTO deleteResponse(Product product) {
		DeleteProductResponseDTO dto = new DeleteProductResponseDTO();
		
			dto.setProduct_Id(product.getProduct_Id());
			dto.setProductName(product.getProductName());
			dto.setMessage("Succesfully Deleted");
			return dto;
	}


}
