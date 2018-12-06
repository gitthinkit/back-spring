package eu.spb.dao;

import eu.spb.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long> {

}
