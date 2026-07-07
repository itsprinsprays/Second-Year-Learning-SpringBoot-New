package SpringbootJPA3.dto;

public class GetCourseResponseDTO {
	
	private Long course_Id;
	
	private String course_name;

	private int unit;
	
	public GetCourseResponseDTO() { }
	
	public Long getCourse_Id() { return course_Id; }
	public String getCourse_Name() { return course_name; }
	public int getUnit() { return unit; }
	
	public void setCourse_Id(Long course_Id) { this.course_Id = course_Id; }
	public void setCourse_Name(String course_name) { this.course_name = course_name; }
	public void setUnit(int unit) { this.unit = unit; }
	
	
}
