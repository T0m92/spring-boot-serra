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

import it.agriBoot.model.Profili;
import it.agriBoot.service.ProfiliService;

@RestController
@RequestMapping("/prof")
public class ProfiliController {
	
	@Autowired
	private ProfiliService profService;
	
	@GetMapping("/all")
	public List<Profili> findAll(){
		return profService.findAll();
	}	// path: http://localhost:8080/agriBoot/prof/all
	
	@GetMapping("/findid/{id}")
	public Profili findById(@PathVariable("id") Integer id){
		return profService.findById(id);
	}	// path: http://localhost:8080/agriBoot/prof/findid/{id}
	
	@PostMapping("/new")
	public List<Profili> newProf(@RequestBody Profili prof){
		profService.newProf(prof);
		return profService.findAll();
	}	// path: http://localhost:8080/agriBoot/prof/new
	
	@PostMapping("/del/{id}")
	public List<Profili> deleteById(@PathVariable("id") Integer id){
		profService.delById(id);
		return profService.findAll();
	}	// path: http://localhost:8080/agriBoot/prof/del/{id}
	
	@PutMapping("/mod/{id}")
	public Profili modProf(@PathVariable("id") Integer id, @RequestBody Profili prof) {
		profService.modProf(id, prof);
		return profService.findById(id);
	}	// path: http://localhost:8080/agriBoot/prof/mod/{id}
}
