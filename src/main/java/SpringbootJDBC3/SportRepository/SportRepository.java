package SpringbootJDBC3.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringbootJDBC3.SportModel.Sport;

@Repository
public class SportRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SportRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Sport> rowMapper = (rs, column) ->
		new Sport(rs.getInt("sports_id"), rs.getString("sports_name")
				);
		
	public int createSport(Sport sport) {
		String sql = "Insert into sport (sports_id, sports_name) values (?,?)";
		return jdbcTemplate.update(sql, sport.getSportID(), sport.getSportName());
	}
}
