package SpringbootJDBC3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC3.Service.SportCRUDService;
import SpringbootJDBC3.SportModel.Sport;

@RestController
@RequestMapping("/CRUD")
@CrossOrigin(origins = "*")
public class CRUDController {
	
	SportCRUDService SService;
	
	@Autowired
	public CRUDController(SportCRUDService SService) {
		this.SService = SService;
	}
	
	@PostMapping
	public String createSport(@RequestBody Sport sport) {
		String result = SService.createSport(sport);
		return result;
	}
	

}
