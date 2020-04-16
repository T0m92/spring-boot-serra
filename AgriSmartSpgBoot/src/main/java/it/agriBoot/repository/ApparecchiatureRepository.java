package it.agriBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.agriBoot.model.Apparecchiature;

@Repository
public interface ApparecchiatureRepository extends JpaRepository<Apparecchiature,Integer> {

}
