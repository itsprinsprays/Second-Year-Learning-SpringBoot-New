package SpringbootJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringbootJDBC.model.Student;
import SpringbootJDBC.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository repo;
	
	@Autowired
	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}
	
	public String createStudent(Student student) {
		 repo.createStudent(student);
		 return "Created Student ";
	}
	
	public List<Student> getAllStudents() {
		return repo.getAll();
	}
	
	public Student findByID(int id) {
		return repo.findByID(id);
	}
	
	public List<Student> findByAge(int age) {
		return repo.findByAge(age);
	}
	
	public String updateStudent(Student student) {
		 repo.updateStudent(student);
		 return "Updated";
	}
	
	public String deleteStudent(int id) {
		repo.deleteByID(id);
		return "Deleted";
	}

	
}
