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

import it.agriBoot.model.Serra;
import it.agriBoot.service.SerraService;
import it.agriBoot.utils.ProfiloDTO;
import it.agriBoot.utils.SerraDTO;

@RestController
@RequestMapping("/serra")
public class SerraController {

		@Autowired
		private SerraService serraService;
		
		@GetMapping("/all")
		public List<Serra> findAll(){
			return serraService.findAll();
		}	// path: http://localhost:8080/agriBoot/serra/all
		
		@GetMapping("/findid/{id}")
		public Serra findById(@PathVariable("id") Integer id){
			return serraService.findById(id);
		}	// path: http://localhost:8080/agriBoot/serra/findid/{id}
		
		@PostMapping("/new")
		public List<Serra> newSerra(@RequestBody Serra serra){
			serraService.newSerra(serra);
			return findAll();
		}	// path: http://localhost:8080/agriBoot/serra/new
		
		@PostMapping("/del/{id}")
		public List<Serra> delById(@PathVariable("id") Integer id){
			return serraService.eraseById(id);
		}	// path: http://localhost:8080/agriBoot/serra/del
		
		@PutMapping("/mod/{id}")
		public Serra modSerra(@PathVariable("id") Integer id,@RequestBody Serra serra) {
			serraService.modSerra(id, serra);
			return serraService.findById(id);
		} // path: http://localhost:8080/agriBoot/serra/mod/{id}
		
		///////custom named queries
		@GetMapping("/trovanome/{nome}")
		public List<Serra> trovaNome(@PathVariable("nome") String nome){
			return serraService.trovanome(nome);
		}	// path: http://localhost:8080/agriBoot/serra/trovanome/{nome}  (della serra)
		///// DA VERIFICARE!!
		@GetMapping("contaprof/{nome}")
		public SerraDTO contaprof(@PathVariable("nome") String nome) {
			return serraService.contaProf(nome);
		}	// path: http://localhost:8080/agriBoot/serra/contaprof/{nome}  (della serra)
		@GetMapping("contaconfig/{nome}")
		public ProfiloDTO contaConfig(@PathVariable("nome") String nome) {
			return serraService.contaConf(nome);			
		}	// path: http://localhost:8080/agriBoot/serra/contaconfig/{nome}  (della serra)
}
