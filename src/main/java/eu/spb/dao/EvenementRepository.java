package eu.spb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.spb.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
