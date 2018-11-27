package eu.spb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.spb.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

}
