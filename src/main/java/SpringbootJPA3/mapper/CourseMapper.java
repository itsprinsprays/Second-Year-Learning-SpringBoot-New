package SpringbootJPA3.mapper;

import org.springframework.stereotype.Component;

import SpringbootJPA3.dto.GetCourseResponseDTO;
import SpringbootJPA3.entity.Course;

@Component
public class CourseMapper {
		
	public CourseMapper() { } 
	
	public GetCourseResponseDTO toResponse(Course course) {
		
		GetCourseResponseDTO dto = new GetCourseResponseDTO();
		
		dto.setCourse_Id(course.getCourseId());
		dto.setCourse_Name(course.getCourseName());
		dto.setUnit(dto.getUnit());
		
		return dto;
		
	}

}
