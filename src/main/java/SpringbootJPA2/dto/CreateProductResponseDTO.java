package SpringbootJPA2.dto;


public class CreateProductResponseDTO {
	
	private String productName;
	
	private String description;
	
	private int stockQuantity;
	
	private String unit;
	
	public CreateProductResponseDTO() { }
	
	public String getProductName() { return productName; }
	public String getDescription() { return description; }
	public int getStockQuantity() { return stockQuantity; }
	public String getUnit() { return unit; }
	
	public void setProductName(String productName) { this.productName = productName; }
	public void setDescription(String description) { this.description = description; }
	public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
	public void setUnit(String unit) { this.unit = unit; }

	
	

}
