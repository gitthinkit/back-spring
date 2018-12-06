package eu.spb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.spb.entities.User;

public interface UserRepository extends JpaRepository<User,String> {
}
