package SpringbootJPA2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RestockProductRequestDTO {
	
	@NotNull(message = "Product Id must not be null")
	private Long product_Id;
	
	@NotNull(message = "Product Name is required")
	private String productName;
	
	@Size(min = 1, message = "Stock must be greater than 0")
	private int stockQuantity;
	
	public RestockProductRequestDTO () { }
	
	public Long getProduct_Id() { return product_Id; }
	public String getProductName() { return productName; }
	public int getStockQuantity() { return stockQuantity; }
	
	public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; } 

}
