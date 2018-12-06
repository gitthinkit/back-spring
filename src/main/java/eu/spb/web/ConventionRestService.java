package eu.spb.web;

import java.awt.PageAttributes.MediaType;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import eu.spb.dao.ConventionRepository;
import eu.spb.entities.Convention;
import eu.spb.entities.Evenement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Conventions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ConventionRestService {
	@Autowired
	private ConventionRepository conventionRepository;
	
	
	//liste des conventions
	@RequestMapping(value="/listeConvention",method=RequestMethod.GET)
	
	public List<Convention> getConventions(){
		return (List<Convention>) conventionRepository.findAll();
	}
	
	
	
	//recherche de convention
	@RequestMapping(value="/rechercheConvention/{id}",method=RequestMethod.GET)
	public String rechConventionid(@PathVariable Long id){
		if( conventionRepository.findById(id) != null)
		{ 
		return "existe";
		}
		else {return "not existe";
		
		}
	}

	
	//ajout d'une convention

	@PostMapping("/ajoutConvention")
	public ResponseEntity<Object> createConvention(@Valid @RequestBody Convention conv) {
		Convention savedconv = conventionRepository.save(conv);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedconv.getIdConv()).toUri();

		return ResponseEntity.created(location).build();

	}
	


	// Update
	@PutMapping(value="/admin/c/update")
	public Map update(@RequestBody Convention e) {
		return Collections.singletonMap("verif",(conventionRepository.save(e)==null)? false : true );
	}
	

	//supprimer une convention
	@DeleteMapping("/supprimerConvention/{id}")
	public String suppConvention(@PathVariable Long id) {
		conventionRepository.deleteById(id);
		if(conventionRepository.findById(id) == null)
		{
			return("convention est bien supprimer!!");
		}
		else 
				return("convention n'existe pas, donc on ne peut pas le supprimer !");
	
		}
			
	
	

	


}