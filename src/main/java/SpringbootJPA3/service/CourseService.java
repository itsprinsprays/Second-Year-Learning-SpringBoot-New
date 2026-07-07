package SpringbootJPA3.service;

import org.springframework.stereotype.Service;

import SpringbootJPA3.dto.GetCourseResponseDTO;
import SpringbootJPA3.entity.Course;
import SpringbootJPA3.mapper.CourseMapper;
import SpringbootJPA3.repository.CourseRepository;

@Service
public class CourseService {
	
	private final CourseRepository crepo;
	private final CourseMapper mapper;
	
	public CourseService(CourseRepository crepo, CourseMapper mapper) {
		this.crepo = crepo;
		this.mapper = mapper;
	}
	
	public GetCourseResponseDTO getCourseById(Long Id) throws Exception {
		
		Course course = crepo.findByCourseId(Id)
				.orElseThrow(() -> new Exception("Course ID is not Existing"));
		
		return mapper.toResponse(course);
		
	}

}
