package SpringbootJPA.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJPA.entity.Pupils;
import SpringbootJPA.service.PupilService;

@RestController
@RequestMapping("/pupils")
public class PupilsController {

	private final PupilService serv;
	
	public PupilsController(PupilService serv) {
		this.serv = serv;
	}
	
	
	@PostMapping
	public Pupils createPupil(@RequestBody Pupils pupil) {
		return serv.createPupils(pupil);
	}
	
	@GetMapping
	public List<Pupils> getAllPupils() {
		return serv.getAllPupil();
	}
	
	@GetMapping("/{ID}")
	public Pupils getPupilByID(@PathVariable Long ID) {
		return serv.findPupilByID(ID);
	}
	
	@DeleteMapping("/{ID}")
	public void deletePupil(@PathVariable Long ID) {
		 serv.deletePupils(ID);
	}
} 
