package SpringbootJDBC3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringbootJDBC3.AthleteModel.Athlete;
import SpringbootJDBC3.AthleteRepository.*;
import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.SportRepository.*;

@Service
public class RegisterService {
	
	private final AthleteRepository athleteRepository;
	private final SportRepository sportRepository;
	
	@Autowired
	public RegisterService(AthleteRepository athleteRepository, SportRepository sportRepository) {
		this.athleteRepository = athleteRepository;
		this.sportRepository = sportRepository;
	}
	 
	public String registerAthlete(Athlete athlete) {
		Sport sport = sportRepository.getSportByID(athlete.getSportID());
        if (sport == null) {
            return "Sport not found. Please register the sport first.";
        }
        athleteRepository.createAthlete(athlete);
        return "Athlete registered successfully under sport: " + sport.getSportName();
    }


	}

