package SpringbootJDBC3.AthleteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringbootJDBC3.AthleteModel.Athlete;

@Repository
public class AthleteRepository implements AthleteImp{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AthleteRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Athlete> athleteRowMapper = (rs, column) ->
		new Athlete(rs.getInt("athlete_id"), 
				    rs.getString("athlete_name"), 
				    rs.getInt("age"),
				    rs.getInt("sport_id")
				);
	
	@Override
	public int createAthlete(Athlete athlete) {
		String sql = "INSERT INTO athlete (athlete_id, athlete_name, age, sport_id) values (?,?,?,?)";
		return jdbcTemplate.update(sql, athlete.getAthleteID(), athlete.getAthleteName(), athlete.getAge(), athlete.getSportID()
				);
	}
	
	@Override
	public List<Athlete> getAllAthlete() {
		String sql = "SELECT * from athlete";
		return jdbcTemplate.query(sql, athleteRowMapper);
	}
	
	@Override
	public Athlete getAthleteByID(int ID) {
		String sql = "SELECT * from athlete where athlete_id = ?";
		return jdbcTemplate.queryForObject(sql, athleteRowMapper, ID);
	}
	
	@Override
	public int updateAthlete(Athlete athlete) {
		String sql = "UPDATE athlete set athlete_name = ? , age = ? where athlete_id = ?";
		return jdbcTemplate.update(sql, athlete.getAthleteName(), athlete.getAge(), athlete.getAthleteID());
	}
	
	@Override
	public int deleteAthleteByID(int ID) {
		String sql = "DELETE FROM athlete where athlete_id = ?";
		return jdbcTemplate.update(sql,ID);
	}
	
	
}
