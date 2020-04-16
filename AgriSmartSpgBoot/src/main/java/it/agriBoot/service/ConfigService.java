package it.agriBoot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.agriBoot.model.Config;
import it.agriBoot.repository.ConfigRepository;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigRepository configRepo;
	
	public ArrayList<Config> findAll(){
		return (ArrayList<Config>) configRepo.findAll();
	}
	
	public Config findById(Integer id){
		return (Config) configRepo.findById(id).get();
	}
	
	public void newConfig(Config conf) {
		configRepo.save(conf);
	}
	
	public void delById(Integer id) {
		configRepo.deleteById(id);
	}
	
	public void modConfig(Integer id, Config conf) {
		conf.setIdConf(id);
		configRepo.save(conf);
	}
}
