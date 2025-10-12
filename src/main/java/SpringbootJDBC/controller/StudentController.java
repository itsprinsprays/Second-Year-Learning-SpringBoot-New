package SpringbootJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC.model.Student;
import SpringbootJDBC.repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin (origins = "*")
public class StudentController {
	
	
	private final StudentRepository repo;
	
	@Autowired
	public StudentController(StudentRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping
	public String createStudent(@RequestBody Student student) {
		 repo.createStudent(student);
		 return "New Student Added";
	}
	
	@GetMapping("/{id}")
	public Student getStudentByID(@PathVariable int id) { 
		return repo.findByID(id);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return repo.getAll();
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(@RequestParam(required = false) Integer age) {
	    if (age != null) {
	        return repo.findByAge(age);
	    }
	    return repo.getAll();
	}
	
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student) {
		student.setID(id);
		repo.updateStudent(student);
		return id + " is updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		 repo.deleteByID(id);
		 return id + " is deleted";
	}
	
	

}
