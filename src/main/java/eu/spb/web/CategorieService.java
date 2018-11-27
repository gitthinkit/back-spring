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

import eu.spb.dao.CategorieRepository;
import eu.spb.entities.Categorie;

@RestController
@CrossOrigin(origins="*")
public class CategorieService {
	@Autowired
	CategorieRepository categorierep;
	
	// liste
	@RequestMapping(value="/admin/categories")
	public List<Categorie> lister() {
		return categorierep.findAll();		
	}
	// get One 
	@RequestMapping(value="/admin/categorie/{id}")
	public Categorie getbyid(@PathVariable int id) {
		Categorie c = categorierep.getOne(id);
		return new Categorie(id,c.getDescription(),c.getNom());		
	}
	// Ajout
	@PostMapping(value="/admin/categorie/add")
	public Map ajouter(@Valid @RequestBody Categorie c) {
		return Collections.singletonMap("verif",(categorierep.save(c)==null) ? false : true );		
	}
	// Update
	@PutMapping(value="/admin/categorie/update")
	public Map update(@RequestBody Categorie c) {
		return Collections.singletonMap("verif",(categorierep.save(c)==null)? false : true );
	}
	//delete
	@DeleteMapping(value="/admin/categorie/delete/{id}")
	public void update(@PathVariable int id) {
		categorierep.delete(categorierep.getOne(id));
	}
}
