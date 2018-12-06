package eu.spb.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.spb.dao.FeedbackRepository;

import eu.spb.entities.Feedback;

@RestController
@CrossOrigin(origins="*")
public class FeedbackRestService {
	@Autowired
	FeedbackRepository feedbackrep;
	
	
	// liste
	@RequestMapping(value="/user/feedback")
	public List<Feedback> lister() {
		return feedbackrep.findAll();		
	}
	// get One 
	@RequestMapping(value="/user/feedback/{id}")
	public Feedback getbyid(@PathVariable long id) {
		Feedback f = feedbackrep.getOne(id);
		return new Feedback(id,f.getDescription(),f.getDatefeed(),f.getEvent(),f.getUser());		
	}
	// Ajout
	@PostMapping(value="/user/feedback/add")
	public Map ajouter(@Valid @RequestBody Feedback f) {
		return Collections.singletonMap("verif",(feedbackrep.save(f)==null) ? false : true );		
	}
	// Update
	@PutMapping(value="/user/feedback/update")
	public Map update(@RequestBody Feedback f) {
		return Collections.singletonMap("verif",(feedbackrep.save(f)==null)? false : true );
	}
	//delete
	@DeleteMapping(value="/user/feedback/delete/{id}")
	public void update(@PathVariable long id) {
		feedbackrep.delete(feedbackrep.getOne(id));
	}
}
