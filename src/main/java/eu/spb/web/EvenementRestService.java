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


import eu.spb.dao.EvenementRepository;

import eu.spb.entities.Evenement;


@RestController
@CrossOrigin(origins="*")
public class EvenementRestService {
	@Autowired
	private EvenementRepository evenementRepo;
	
	// liste
		@RequestMapping(value="/evenements")
		public List<Evenement> lister() {
			return evenementRepo.findAll();		
		}
		
		
		// get One 
		@RequestMapping(value="/user/evenements/{id}")
		public Evenement getbyid(@PathVariable long id) {
			Evenement e = evenementRepo.getOne(id);
			return new Evenement(id,e.getDescription(),e.getTitre());		
		}
		
		
		// Ajout
		@PostMapping(value="/admin/evenement/add")
		public Map ajouter(@Valid @RequestBody Evenement e) {
			return Collections.singletonMap("verif",(evenementRepo.save(e)==null) ? false : true );		
		}
		
		// Update
		@PutMapping(value="/admin/evenements/update")
		public Map update(@RequestBody Evenement e) {
			return Collections.singletonMap("verif",(evenementRepo.save(e)==null)? false : true );
		}
		//delete
		@DeleteMapping(value="/admin/evenements/delete/{id}")
		public void update(@PathVariable long id) {
			evenementRepo.delete(evenementRepo.getOne(id));
		}
}
