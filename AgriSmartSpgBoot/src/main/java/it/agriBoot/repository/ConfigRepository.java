package it.agriBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.agriBoot.model.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config,Integer> {

}
