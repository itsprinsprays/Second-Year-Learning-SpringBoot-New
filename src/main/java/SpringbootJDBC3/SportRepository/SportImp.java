package SpringbootJDBC3.SportRepository;

import java.util.List;

import SpringbootJDBC3.AthleteModel.Athlete;
import SpringbootJDBC3.SportModel.Sport;

public interface SportImp {
	
	Sport createSport(Sport sport);
	List<Sport> getAllSport();
	Sport getSportByID(int ID);
	List<Athlete> getAllAthletes();
	int updateSport(Sport sport);
	int deleteSportByID(int ID);
	
}
