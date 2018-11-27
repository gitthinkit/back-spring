package eu.spb.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.spb.dao.UserRepository;
import eu.spb.entities.User;

@RestController
@CrossOrigin(origins="*")
public class UserService {
	@Autowired
	private UserRepository userrep ;
	@Autowired
	private PasswordEncoder passwordEncoder ;
	@Autowired
	public JavaMailSender emailSender;

	@PostMapping(value="/login")
	public Map login(@RequestBody HashMap<String,String> req) {
		if(userrep.findById(req.get("email")).isPresent()) {
			User u = userrep.getOne(req.get("email")) ;
			HashMap<String,Object>  m  =new HashMap<String,Object>();
			m.put("verif",passwordEncoder.matches(req.get("password"),u.getPassword()));
			u.setPassword("");
			m.put("user", u);
			return m ;
		}
		return Collections.singletonMap("verif",false);
	}
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public void logout (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	}
	@PostMapping(value="/all/mail_existe")
    public Map mailexiste(@RequestBody HashMap<String,String> req){
		return Collections.singletonMap("verif",userrep.findById(req.get("email")).isPresent());
    }
	@RequestMapping(value="/inscrire", method= RequestMethod.POST)
    public Map inscription(@Valid @RequestBody User u){
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return Collections.singletonMap("verif",(userrep.save(u)==null) ? false : true );		
    }
	@PostMapping(value="/all/verif_mail")
    public Map verifmail(@RequestParam(name = "email") String email){
		Random rand = new Random();
		int code = rand.nextInt(999999 + 1 - 100000) + 100000 ;
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Spb verification"); 
        message.setText(code+"");
        emailSender.send(message);
        return Collections.singletonMap("code",code);
    }
	// list users
	@RequestMapping(value="/admin/users")
	public List<User> getusers(){
		List<User> lst = userrep.findAll() ;
		lst.forEach(u->{u.setPassword("");});
		return lst ;
	}
	//get user by id 
	@RequestMapping(value="/admin/user/{email}")
	public User getUser(@PathVariable String email) {
		User u = userrep.getOne(email);
		return new User(u.getEmail(),u.getNom(),u.getPrenom(),"",u.getTel(),u.getRole()) ;
	}
	//delete User
	@DeleteMapping(value="/admin/user/delete/{email}")
	public void delete(@PathVariable String email) {
		userrep.delete(userrep.getOne(email));
	}
	// update
	@PutMapping("/admin/user/update")
	public Map updateuser(@RequestBody User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return Collections.singletonMap("verif",(userrep.save(u)==null) ? false : true );
	}
}
