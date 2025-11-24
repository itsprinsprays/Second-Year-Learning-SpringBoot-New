package SpringbootJDBC3.AthleteRepository;

import SpringbootJDBC3.AthleteModel.Athlete;
import java.util.List;

public interface AthleteImp {
	
	int createAthlete(Athlete athlete);
	List<Athlete> getAllAthlete();
	Athlete getAthleteByID(int ID);
	int updateAthlete(Athlete athlete);
	int deleteAthleteByID(int ID);
	
}
