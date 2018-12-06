package eu.spb.dao;


import eu.spb.entities.Convention;
import org.springframework.data.repository.CrudRepository;

public interface ConventionRepository extends CrudRepository<Convention, Long> {

}
