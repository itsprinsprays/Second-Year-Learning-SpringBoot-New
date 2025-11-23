package SpringbootJDBC3.AthleteRepository;

import SpringbootJDBC3.AthleteModel.Athlete;
import java.util.List;

public interface AthleteImp {
	
	Athlete createAthlete(Athlete athlete);
	List<Athlete> getAllAthlete();
	Athlete getAtheleteByID(int ID);
	int updateAthelete(Athlete athlete);
	int deleteAthleteByID(int ID);
	
}
