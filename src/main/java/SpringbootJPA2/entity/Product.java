package SpringbootJPA2.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import SpringbootJPA2.Status;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long department_Id;
	
	@CreationTimestamp
	private LocalDateTime created_At;
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private int stockQuantity;
	
	@Column(nullable = false) 
	private String unit;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.ACTIVE;
	
	
	public Product() { }
	
	public Long getDepartment_Id() { return department_Id; }
	public LocalDateTime getCreated_At() { return created_At; }
	public String getProductName() { return productName; }
	public String getDescription() { return description; }
	public int getStockQuantity() { return stockQuantity; }
	public String getUnit() { return unit; }
	public Status getStatus() { return status; }
	
	public void setDepartment_Id(Long department_Id) { this.department_Id = department_Id; }
	public void setCreated_At(LocalDateTime created_At) { this.created_At = created_At; }
	public void setProductName(String productName) { this.productName = productName; }
	public void setDescription(String description) { this.description = description; }
	public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
	public void setUnit(String unit) { this.unit = unit; }
	public void setStatus(Status status) { this.status = status; }
	
	
	
	
	

}
