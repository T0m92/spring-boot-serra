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

import it.agriBoot.model.Apparecchiature;
import it.agriBoot.service.ApparecchiatureService;

@RestController
@RequestMapping("/appar")
public class ApparecchiatureController {
	
	@Autowired
	private ApparecchiatureService apparService;
	
	@GetMapping("/all")
	public List<Apparecchiature> findAll(){
		return apparService.findAll();
	} 	// path: http://localhost:8080/agriBoot/appar/all
	
	@GetMapping("/findid/{id}")
	public Apparecchiature findById(@PathVariable("id") Integer id) {
		return apparService.findById(id);
	} 	// path: http://localhost:8080/agriBoot/appar/findid/{id}
	
	@PostMapping("/new")
	public List<Apparecchiature> newApparecchiatura(@RequestBody Apparecchiature appar){
		apparService.newAppar(appar);
		return apparService.findAll();
	} 	// path: http://localhost:8080/agriBoot/appar/new
	
	@PostMapping("/del/{id}")
	public List<Apparecchiature> delid(@PathVariable("id") Integer id){
		apparService.delById(id);
		return apparService.findAll();
	} 	// path: http://localhost:8080/agriBoot/appar/del/{id}
	
	@PutMapping("/mod/{id}")
	public Apparecchiature modApp(@PathVariable("id") Integer id,@RequestBody Apparecchiature app) {
		apparService.modApp(app, id);
		return apparService.findById(id);
	} 	// path: http://localhost:8080/agriBoot/appar/mod/{id}
}
