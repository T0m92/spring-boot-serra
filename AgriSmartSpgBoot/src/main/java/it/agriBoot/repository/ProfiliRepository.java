package it.agriBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.agriBoot.model.Profili;

@Repository
public interface ProfiliRepository extends JpaRepository<Profili,Integer> {

}
