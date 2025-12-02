package SpringbootJDBC3.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringbootJDBC3.AthleteModel.Athlete;
import SpringbootJDBC3.AthleteRepository.AthleteRepository;
import SpringbootJDBC3.Exception.AthleteIsExistingException;
import SpringbootJDBC3.Exception.AthleteNotFoundException;
import SpringbootJDBC3.Exception.SportIsExistingException;
import SpringbootJDBC3.Exception.SportNotFoundException;
import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.SportRepository.SportRepository;

@Service
public class SportAthleteCRUDService {
	
	private final SportRepository sRepo;
	private final AthleteRepository aRepo;
	
	public SportAthleteCRUDService(SportRepository sRepo, AthleteRepository aRepo) {
		this.sRepo = sRepo;
		this.aRepo = aRepo;
	}
	
	//Sport CRUD
	
	public String createSport(Sport sport) {
		 Sport check = sRepo.getSportByID(sport.getSportID());
		 if(check != null) {
			throw new SportIsExistingException ("Sport ID : " + sport.getSportID() + " is already existed");
		 } 
		sRepo.createSport(sport);
		return "Sports Created ID : " + sport.getSportID();
	}
	
	public List<Sport> getAllSport() {
		return sRepo.getAllSports();
	}
	
	public Sport getSportByID(int ID) {
		Sport check = sRepo.getSportByID(ID);
		if(check == null) {
			throw new SportNotFoundException("Sport ID : " + ID + " is not existing");
		}
		return check;
	}
	
	
	public String updateSport(Sport sport) {
		Sport check = sRepo.getSportByID(sport.getSportID());
		if(check == null) {
			  throw new SportNotFoundException ("Sport ID " + sport.getSportID() + " does not exist!");
		}
		 sRepo.updateSport(sport);
		 return "Sport ID : " + check.getSportID() + " Updated";
	}
	
	public String deleteSportByID(int ID) {
		String name = sRepo.getSportNameByID(ID);
		Sport check = sRepo.getSportByID(ID);
		
		if(check == null) {
			 throw new SportNotFoundException ("Sport ID " + ID + " does not exist!");
		}	
		
		 sRepo.deleteSportByID(ID);
		 return "Deleted Sport Name : " + name;
	}
	
	
	//Athlete CRUD
	
	public String createAthlete(Athlete athlete) {
		Athlete check = aRepo.getAthleteByID(athlete.getAthleteID());
		if(check != null) {
			throw new AthleteIsExistingException ("Athlete ID : " + athlete.getAthleteID() + " is already existed");
		}
		aRepo.createAthlete(athlete);
		return "Athlete ID : " + athlete.getAthleteID() + " created";
	}
	
	public List<Athlete> getAllAthlete() {
		return aRepo.getAllAthlete();
	}
	
	public Athlete getAthleteByID(int ID) {
		Athlete check = aRepo.getAthleteByID(ID);
		if(check == null) {
			throw new AthleteNotFoundException("Athlete ID : " + ID + " is not existing");
		}
		return check;
	}
	
	public int updateAthlete(Athlete athlete) {
		return aRepo.updateAthlete(athlete);
	}
	
	public int deleteAthleteByID(int ID) {
		return aRepo.deleteAthleteByID(ID);
	}

}
