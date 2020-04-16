package it.agriBoot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.agriBoot.model.Profili;
import it.agriBoot.repository.ProfiliRepository;

@Service
public class ProfiliService {
	@Autowired
	private ProfiliRepository profRepo;
	
	public ArrayList<Profili> findAll(){
		return (ArrayList<Profili>) profRepo.findAll();
	}
	
	public Profili findById(Integer id){
		return (Profili) profRepo.findById(id).get();
	}
	
	public void newProf(Profili prof) {
		profRepo.save(prof);
	}
	
	public void delById(Integer id) {
		profRepo.deleteById(id);
	}
	
	public void modProf(Integer id, Profili prof) {
		prof.setIdProf(id);
		profRepo.save(prof);
	}

}
