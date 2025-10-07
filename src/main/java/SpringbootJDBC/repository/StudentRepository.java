package SpringbootJDBC.repository;

import org.springframework.jdbc.core.RowMapper;
import SpringbootJDBC.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements StudentImp{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Student> rowMapper = (rs, column) -> 
				new Student(rs.getString("FullName"), rs.getString("Section"), rs.getInt("Age"), rs.getInt("SID")
					);
				
	@Override
	public int createStudent(Student student) {
		String sql = "Insert into student";
		return jdbcTemplate.update(sql, student.getFullName(), student.getSection(), student.getAge(), student.getID());
	}
	


}
