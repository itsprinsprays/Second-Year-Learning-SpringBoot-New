package SpringbootJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringbootJDBC.repository.StudentRepository;
import SpringbootJPA.entity.Pupils;
import SpringbootJPA.exception.SIDExistingException;
import SpringbootJPA.repository.PupilsRepository;

@Service
public class PupilService {
	
	private final PupilsRepository repo;
	
	public PupilService(PupilsRepository repo) {
		this.repo = repo;
	}
	
	public Pupils createPupils(Pupils pupil) {
		if(repo.findById(pupil.getSID()).isPresent()) {
			throw new SIDExistingException("Student ID is Existing...");
		}
		return repo.save(pupil);
	}
	
	public List<Pupils> getAllPupil() {
		return repo.findAll();
	}
	
	public Pupils findPupilByID(Long ID) {
		return repo.findById(ID)
				.orElseThrow(() -> new RuntimeException("Student Not Found"));
	}

	public Pupils deletePupils(Long ID) {
		Pupils pupil = repo.findById(ID)
						   .orElseThrow(() -> new RuntimeException("Student Not Found"));
		repo.delete(pupil);
		return pupil;
	}
}
 