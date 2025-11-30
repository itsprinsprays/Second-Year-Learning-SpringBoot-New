package SpringbootJDBC3.Service;

import org.springframework.stereotype.Service;

import SpringbootJDBC3.SportModel.Sport;
import SpringbootJDBC3.SportRepository.SportRepository;

@Service
public class SportCRUDService {
	
	SportRepository sRepo;
	
	public SportCRUDService(SportRepository sRepo) {
		this.sRepo = sRepo;
	}
	
	public String createSport(Sport sport) {
		 Sport check = sRepo.getSportByID(sport.getSportID());
		 if(check != null) {
			return ("Sport ID : " + sport.getSportID() + " is already existed");
		 } 
		sRepo.createSport(sport);
		return "Sports Created ID : " + sport.getSportID();
		
	}

}
