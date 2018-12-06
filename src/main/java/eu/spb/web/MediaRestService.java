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

import eu.spb.dao.MediaRepository;
import eu.spb.entities.Media;

@RestController
@CrossOrigin(origins="*")
public class MediaRestService {
	@Autowired
	MediaRepository mediarepo;
	
	// liste
	@RequestMapping(value="/admin/media")
	public List<Media> lister() {
		return mediarepo.findAll();		
	}
	// get One 
	@RequestMapping(value="/user/media/{id}")
	public Media getbyid(@PathVariable long id) {
		Media m = mediarepo.getOne(id);
		return new Media(id,m.getPath());		
	}
	// Ajout
	@PostMapping(value="/admin/media/add")
	public Map ajouter(@Valid @RequestBody Media m) {
		return Collections.singletonMap("verif",(mediarepo.save(m)==null) ? false : true );		
	}
	// Update
	@PutMapping(value="/admin/media/update")
	public Map update(@RequestBody Media m) {
		return Collections.singletonMap("verif",(mediarepo.save(m)==null)? false : true );
	}
	//delete
	@DeleteMapping(value="/media/delete/{id}")
	public void update(@PathVariable long id) {
		mediarepo.delete(mediarepo.getOne(id));
	}
}
