package SpringbootJDBC3.SportRepository;

import java.util.List;

import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.AthleteModel.Athlete;

public interface SportImp {
	
	int createSport(Sport sport);
	List<Sport> getAllSports();
	Sport getSportByID(int ID);
	Sport getSportByName(String sportName);
	List<Athlete> getAllAthletes();
	int updateSport(Sport sport);
	int deleteSportByID(int ID);
	
}
