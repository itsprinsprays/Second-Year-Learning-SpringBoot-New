package SpringbootJDBC3.SportRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.AthleteModel.Athlete;

@Repository
public class SportRepository implements SportImp{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SportRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Sport> sportRowMapper = (rs, column) ->
		new Sport(rs.getInt("sport_id"), rs.getString("sport_name")
				);
		
	private RowMapper<Athlete> athleteRowMapper = (rs, column) ->
		new Athlete(rs.getInt("athlete_id"), rs.getString("athlete_name"), rs.getInt("age"), rs.getInt("sport_id"));
	
	@Override
	public int createSport(Sport sport) {
		String sql = "INSERT INTO sport (sport_id, sport_name) VALUES (?,?)";
		return jdbcTemplate.update(sql, sport.getSportID(), sport.getSportName());
	}
	
	@Override
	public List<Sport> getAllSports() {
		String sql = "SELECT * FROM sport";
		return jdbcTemplate.query(sql, sportRowMapper);
	}
	
	@Override
	public Sport getSportByID(int ID) {
		String sql = "SELECT * FROM sport WHERE sport_id = ?";	
		return jdbcTemplate.queryForObject(sql, sportRowMapper,ID);
	}
	
	@Override
	public List<Athlete> getAllAthletes() {
		String sql = "SELECT a.athlete_id, a.athlete_name, a.age, a.sport_ID FROM athlete a  JOIN sport s ON a.sport_id  = s.sport_id ";
		return jdbcTemplate.query(sql, athleteRowMapper);
	}
	
	public int updateSport(Sport sport) {
		String sql = "UPDATE sport set sport_name = ? where sport_id = ?";
		return jdbcTemplate.update(sql, sport.getSportName(), sport.getSportID());
	}
	
	public int deleteSportByID(int ID) {
		String sql = "DELETE FROM sport WHERE sport_id = ?";
		return jdbcTemplate.update(sql,ID);
	}
}
