package SpringbootJDBC3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC3.Service.SportAthleteCRUDService;
import SpringbootJDBC3.SportModel.Sport;

@RestController
@RequestMapping("/CRUD")
@CrossOrigin(origins = "*")
public class CRUDController {
	
	SportAthleteCRUDService sService;
	
	@Autowired
	public CRUDController(SportAthleteCRUDService sService) {
		this.sService = sService;
	}
	
	@PostMapping
	public String createSport(@RequestBody Sport sport) {
		String result = sService.createSport(sport);
		return result;
	}
	
	@GetMapping
	public List<Sport> getAllSport() {
		return sService.getAllSport();
	}
	
	@GetMapping("/{ID}")
	public Sport getSportByID(@PathVariable int ID) {
		return sService.getSportByID(ID);
	}
	
	@GetMapping("/name/{sportName}")
	public Sport getSportByName(@PathVariable String sportName) {
		return sService.getSportByName(sportName);
	}
	
	@PutMapping("/{ID}")
	public String updateSport(@PathVariable int ID, @RequestBody Sport sport) {
		sport.setSportID(ID);
		sService.updateSport(sport);
		return "Sport ID " + ID + " Name Updated";
	}
	
	@DeleteMapping("/{ID}")
	public int deleteSportByID(@PathVariable int ID) {
		return sService.deleteSportByID(ID);
	}
	

}
