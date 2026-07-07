package SpringbootJPA3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@Column(nullable = false)
	private String courseName;
	
	@Column(nullable = false)
	private int unit;
	
	public Course() {}
	
	public long getCourseId() { return courseId; }
	public String getCourseName() { return courseName; }
	public int getUnit() { return unit; }
	
	public void setCourseName(String courseName) { this.courseName = courseName; }
	public void setUnit(int unit) { this.unit = unit; }

}
