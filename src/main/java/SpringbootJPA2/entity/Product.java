package SpringbootJPA2.entity;

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
	private int created_at;
	
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
	
	

}
