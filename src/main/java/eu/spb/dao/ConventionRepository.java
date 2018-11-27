package eu.spb.dao;

import java.util.List;

import eu.spb.entities.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConventionRepository extends CrudRepository<Convention, Long> {

}
