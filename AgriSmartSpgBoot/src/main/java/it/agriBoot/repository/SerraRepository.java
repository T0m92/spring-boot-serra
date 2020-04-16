package it.agriBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.agriBoot.model.Serra;

@Repository
public interface SerraRepository extends JpaRepository<Serra,Integer>{

}
