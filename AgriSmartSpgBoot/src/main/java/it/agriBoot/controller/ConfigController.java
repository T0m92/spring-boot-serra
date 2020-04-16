package it.agriBoot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.agriBoot.model.Config;
import it.agriBoot.service.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@Autowired
	private ConfigService configService;
	
	@GetMapping("/all")
	public List<Config> findAll(){
		return configService.findAll();
	}	// path: http://localhost:8080/agriBoot/config/all
	
	@GetMapping("/findid/{id}")
	public Config findById(@PathVariable("id") Integer id){
		return configService.findById(id);
	} // path: http://localhost:8080/agriBoot/config/findid/{id}
	
	@PostMapping("/new")
	public List<Config> newConfig(@RequestBody Config conf){
		configService.newConfig(conf);
		return configService.findAll();
	} // path: http://localhost:8080/agriBoot/config/new
	
	@PostMapping("/del/{id}")
	public List<Config> delById(@PathVariable("id") Integer id){
		configService.delById(id);
		return configService.findAll();
	}  // path: http://localhost:8080/agriBoot/config/del/{id}
	
	@PutMapping("/mod/{id}")
	public Config modConfig(@PathVariable("id") Integer id, @RequestBody Config conf) {
		configService.modConfig(id, conf);
		return configService.findById(id);
	}// path: http://localhost:8080/agriBoot/config/mod/{id}
}
