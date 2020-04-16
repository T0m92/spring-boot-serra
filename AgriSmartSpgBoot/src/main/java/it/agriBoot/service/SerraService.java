package it.agriBoot.service;

import java.util.ArrayList;
import java.util.List;

/////////////////////////////////////////////
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.agriBoot.model.Serra;
import it.agriBoot.repository.SerraRepository;
import it.agriBoot.utils.ProfiloDTO;
import it.agriBoot.utils.SerraDTO;

@Service
public class SerraService {
	
	///////////////////////////////////
	@PersistenceContext
	private EntityManager em;
	
	
	@Autowired
	private SerraRepository serraRepo;
	
	public ArrayList<Serra> findAll(){
		return (ArrayList<Serra>) serraRepo.findAll();
	}
	
	public Serra findById(Integer id){
		return (Serra) serraRepo.findById(id).get();
	}
	
	public void newSerra(Serra serra) {
		serraRepo.save(serra);
	}
	
	public List<Serra> eraseById(Integer id) {
		serraRepo.deleteById(id);
		return  serraRepo.findAll();
	}
	
	public void modSerra(Integer id, Serra sr) {
		sr.setId(id);
		serraRepo.save(sr);
	}
	
	//trova la serra dal nome
	public List<Serra> trovanome(String nome) {
		TypedQuery<Serra> query = em.createNamedQuery("Serra.trovaNome", Serra.class);
		query.setParameter("nome", nome);
		List<Serra> results = query.getResultList();
		return results;
	}
	
	
	//conta i profili associati al nome di una serra
	public SerraDTO contaProf(String nome) {
		TypedQuery<SerraDTO> query = em.createNamedQuery("Serra.contaProfAssociati", SerraDTO.class);
		query.setParameter("nome", nome);
		SerraDTO result = query.getSingleResult();
		return result;
	}
	//conta le configurazioni associate al nome di una serra
	public ProfiloDTO contaConf(String nome) {
		TypedQuery<ProfiloDTO> q = em.createNamedQuery("Serra.contaConfigAssociate", ProfiloDTO.class);
		q.setParameter("nome", nome);
		ProfiloDTO risultato = q.getSingleResult();
		return risultato;
	}
	
}
