package it.agriBoot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.agriBoot.model.Apparecchiature;
import it.agriBoot.repository.ApparecchiatureRepository;

@Service
public class ApparecchiatureService {

	@Autowired
	private ApparecchiatureRepository appaRepo;
	
	public ArrayList<Apparecchiature> findAll(){
		return (ArrayList<Apparecchiature>) appaRepo.findAll();
	}
	
	public Apparecchiature findById(Integer id) {
		return appaRepo.findById(id).get();
	}
	
	public void newAppar(Apparecchiature app) {
		appaRepo.save(app);
	}
	
	public void delById(Integer id) {
		appaRepo.deleteById(id);
	}
	
	public void modApp(Apparecchiature app, Integer id) {
		app.setIdAppar(id);
		appaRepo.save(app);
	}

}
