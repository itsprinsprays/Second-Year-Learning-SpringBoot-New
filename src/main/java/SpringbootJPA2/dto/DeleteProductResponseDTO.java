package SpringbootJPA2.dto;

public class DeleteProductResponseDTO {
	
	private Long product_Id;
	private String productName;
	private String message;
	
	public DeleteProductResponseDTO() { }
	
	public long getProduct_Id() { return product_Id; }
	public String getProductName() { return productName; }
	public String getMessage() { return message; }
	
	public void setProductName(String productName) { this.productName = productName; }
	public void setMessage(String message) { this.message = message; }
	public void setProduct_Id(Long product_Id) { this.product_Id = product_Id; }

}
