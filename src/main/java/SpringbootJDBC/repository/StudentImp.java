package SpringbootJDBC.repository;


import java.util.List;

import SpringbootJDBC.model.Student;

public interface StudentImp {
	
	 int createStudent(Student student);
	 List<Student> getAll();
	 Student findByID(int ID);
	 int updateStudent(Student student);
	 int deleteByID(int id);
	


}
