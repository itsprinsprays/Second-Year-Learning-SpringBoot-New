package SpringbootJDBC3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC3.AthleteModel.Athlete;
import SpringbootJDBC3.Service.RegisterService;

@RequestMapping("/athlete")
@RestController
@CrossOrigin(origins ="*")
public class RegisterController {
	
	RegisterService rService;
	
	@Autowired
	public RegisterController(RegisterService rService) {
		this.rService = rService;
	}
	
	@PostMapping
	public String registerAthlete(@RequestBody Athlete athlete) {
		String result = rService.registerAthlete(athlete);
		return result;
	}

}
