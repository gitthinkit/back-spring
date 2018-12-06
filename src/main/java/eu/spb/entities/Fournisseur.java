package eu.spb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity 
public class Fournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	@Id @GeneratedValue
=======
	@Id
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	@Column(name="id_four")
	private long id_four;
	private String libelle; 
	private String tel;
	private String email;
	private String fax;
	private String adresse;
<<<<<<< HEAD

=======
	
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	public long getId_four() {
		return id_four;
	}
	public void setId_four(long id_four) {
		this.id_four = id_four;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub 
	}
	public Fournisseur(long id_fornisseur, String libelle, String tel, String mail, String fax, String adresse) {
		super();
		this.id_four = id_fornisseur;
		this.libelle = libelle;
		this.tel = tel;
		this.email = mail;
		this.fax = fax;
		this.adresse = adresse;
	}
	
	
}
