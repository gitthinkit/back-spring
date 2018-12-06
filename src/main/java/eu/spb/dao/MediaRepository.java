package eu.spb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.spb.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
