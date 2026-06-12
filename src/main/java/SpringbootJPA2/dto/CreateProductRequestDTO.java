package SpringbootJPA2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProductRequestDTO {
	
	@NotNull(message = "Product Name is Required")
	private String productName;
	
	@NotNull(message = "Description must not be blank")
	private String description;
	
	@NotNull(message = "Stock must not be blank")
	@Size(min = 1, message = "Quantity must be higher than 0")
	private int stockQuantity;
	
	@NotNull(message = "Unit must not be blank")
	private String unit;
	
	public CreateProductRequestDTO() { }
	
	public String getProductName() { return productName; }
	public String getDescription() { return description; }
	public int getStockQuantity() { return stockQuantity; }
	public String getUnit() { return unit; }
	
	public void setProductName(String productName) { this.productName = productName; }
	public void setDescription(String description) { this.description = description; }
	public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
	public void setUnit(String unit) { this.unit = unit; }

	
	

}
