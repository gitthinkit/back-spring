package eu.spb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.spb.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
