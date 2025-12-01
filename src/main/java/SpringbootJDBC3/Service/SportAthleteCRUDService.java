package SpringbootJDBC3.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringbootJDBC3.AthleteModel.Athlete;
import SpringbootJDBC3.AthleteRepository.AthleteRepository;
import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.SportRepository.SportRepository;

@Service
public class SportAthleteCRUDService {
	
	SportRepository sRepo;
	AthleteRepository aRepo;
	
	public SportAthleteCRUDService(SportRepository sRepo, AthleteRepository aRepo) {
		this.sRepo = sRepo;
		this.aRepo = aRepo;
	}
	
	//Sport CRUD
	
	public String createSport(Sport sport) {
		 Sport check = sRepo.getSportByID(sport.getSportID());
		 if(check != null) {
			return ("Sport ID : " + sport.getSportID() + " is already existed");
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
			System.out.print("Sport ID : " + ID + " is not existing");
		}
		return check;
	}
	
	
	public int updateSport(Sport sport) {
		return sRepo.updateSport(sport);
	}
	
	public String deleteSportByID(int ID) {
		String name = sRepo.getSportNameByID(ID);
		Sport check = sRepo.getSportByID(ID);
		if(check == null) {
			   System.out.print("Sport ID " + ID + " does not exist!");
		}
		
		 sRepo.deleteSportByID(ID);
		 return "Deleted Sport Name : " + name;
	}
	
	
	//Athlete CRUD
	
	public String createAthlete(Athlete athlete) {
		Athlete check = aRepo.getAthleteByID(athlete.getSportID());
		if(check != null) {
			return ("Athlete ID : " + athlete.getSportID() + " is already existed");
		}
		aRepo.createAthlete(athlete);
		return "Athlete ID : " + athlete.getSportID() + " created";
	}
	
	public List<Athlete> getAllAthlete() {
		return aRepo.getAllAthlete();
	}
	
	public Athlete getAthleteByID(int ID) {
		Athlete check = aRepo.getAthleteByID(ID);
		if(check == null) {
			System.out.print("Sport ID : " + ID + " is not existing");
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
