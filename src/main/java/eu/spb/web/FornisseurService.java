package eu.spb.web;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import eu.spb.dao.FournisseurRepository;
import eu.spb.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*")
public class FornisseurService {
	@Autowired
	private FournisseurRepository fournisseurRep;

	//liste des fornisseurs
	@RequestMapping(value="/admin/fournisseurs")	
	public List<Fournisseur> getConventions(){
		return fournisseurRep.findAll();
	}
	// get One 
	@RequestMapping(value="/admin/fournisseur/{id}")
	public Fournisseur getbyid(@PathVariable long id) {
		Fournisseur f = fournisseurRep.getOne(id);
		return new Fournisseur(id,f.getLibelle(),f.getTel(),f.getEmail(),f.getFax(),f.getAdresse());		
	}
	// Ajout
	@PostMapping(value="/admin/fournisseur/add")
	public Map ajouter(@Valid @RequestBody Fournisseur f) {
		return Collections.singletonMap("verif",(fournisseurRep.save(f)==null) ? false : true );		
	}
	// Update
	@PutMapping(value="/admin/fournisseur/update")
	public Map update(@RequestBody Fournisseur f) {
		return Collections.singletonMap("verif",(fournisseurRep.save(f)==null)? false : true );
	}
	//delete
	@DeleteMapping(value="/admin/fournisseur/delete/{id}")
	public void update(@PathVariable long id) {
		fournisseurRep.delete(fournisseurRep.getOne(id));
	}
}
