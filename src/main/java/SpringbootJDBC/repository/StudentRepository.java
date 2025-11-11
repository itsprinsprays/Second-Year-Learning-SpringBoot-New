package SpringbootJDBC.repository;

import org.springframework.jdbc.core.RowMapper;
import SpringbootJDBC.model.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements StudentImp{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Student> rowMapper = (rs, rowNum) -> 
				new Student(rs.getString("FullName"), rs.getString("Section"), rs.getInt("Age"), rs.getInt("SID")
					);
			
	//Create
	@Override
	public int createStudent(Student student) {
		String sql = "Insert into student (FullName, Section, Age, SID) values (?,?,?,?)";
		return jdbcTemplate.update(sql, student.getFullName(), student.getSection(), student.getAge(), student.getID());
	}
	
	//Read All
	@Override
	public List<Student> getAll() {
		String sql = "Select * from student";
		return jdbcTemplate.query(sql, rowMapper);
		
	}
	
	//Read by ID
	@Override
	public Student findByID(int id) {
		String sql = "Select * from student where SID = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	
	//Read by Age
	public List<Student> findByAge(int age) {
		String sql = "Select * from student where Age = ?";
		return jdbcTemplate.query(sql, rowMapper, age);
	}
	
	//Update
	@Override
	public int updateStudent(Student student) {
		String sql = "Update student set FullName = ? , Section = ?, Age = ? where SID = ?";
		return jdbcTemplate.update(sql, student.getFullName(), student.getSection(), student.getAge(), student.getID());
	}
	
	//Delete
	@Override
	public int deleteByID(int id) {
		String sql = "Delete from student where SID = ?";
		return jdbcTemplate.update(sql,id);
	}
	
	


}
