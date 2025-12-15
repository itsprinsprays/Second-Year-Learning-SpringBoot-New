package SpringbootJPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pupils")
public class Pupils {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SID;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String section;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	public Pupils() { }
	
	public Pupils(String name, String section, String email) {
		this.name = name;
		this.section = section;
		this.email = email;
	}
	
	public Long getSID() {
		return SID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSection() {
		return section;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSection(String section) {
		this.section = section;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
