package eu.spb.dao;

<<<<<<< HEAD

import eu.spb.entities.Convention;
=======
import java.util.List;

import eu.spb.entities.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
import org.springframework.data.repository.CrudRepository;

public interface ConventionRepository extends CrudRepository<Convention, Long> {

}
