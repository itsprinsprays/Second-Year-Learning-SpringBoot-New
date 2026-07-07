package SpringbootJPA3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJPA3.dto.GetCourseResponseDTO;
import SpringbootJPA3.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<GetCourseResponseDTO> getCourseById(@PathVariable Long Id) throws Exception {
		return ResponseEntity.ok().body(courseService.getCourseById(Id));
	}

}
