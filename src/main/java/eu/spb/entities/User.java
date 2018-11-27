package eu.spb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
    @Column(name="email")
    private String email ;
    @Column(name="nom")
    private String nom ;
    @Column(name="prenom")
    private String prenom ;
    @Column(name="password")
    private String password ;
    @Column(name="tel")
    private String tel ;
    @Column(name="role")
    private String role ;
	public User() {
		super();
	}
	public User(String email, String nom, String prenom, String password, String tel, String role) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.tel = tel;
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
}
