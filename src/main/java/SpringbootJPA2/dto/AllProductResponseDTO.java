package SpringbootJPA2.dto;

import java.time.LocalDateTime;

import SpringbootJPA2.Status;

public class AllProductResponseDTO {
	
	private Long product_Id;
	private LocalDateTime created_At;
	private String productName;
	private String description;
	private int stockQuantity;
	private String unit;
	private Status status;
	
	public AllProductResponseDTO() { }
	
	public Long getProduct_id() { return product_Id; }
	public LocalDateTime getCreated_At() { return created_At; }
	public String getProductName() { return productName; }
	public String getDescription() { return description; }
	public int getStockQuantity() { return stockQuantity; }
	public String getUnit() { return unit; }
	public Status getStatus() { return status; }
	
	public void setProduct_Id(Long product_Id) { this.product_Id = product_Id; }
	public void setCreated_At(LocalDateTime created_At) { this.created_At = created_At; }
	public void setProductName(String productName) { this.productName = productName; }
	public void setDescription(String description) { this.description = description; }
	public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
	public void setUnit(String unit) { this.unit = unit; }
	public void setStatus(Status status) { this.status = status; }

 }
