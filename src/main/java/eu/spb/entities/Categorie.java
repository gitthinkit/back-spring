package eu.spb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_cat")
	private int idCat;
	private String description;
	private String nom;
	
	public Categorie(int idCat, String description, String nom) {
		super();
		this.idCat = idCat;
		this.description = description;
		this.nom = nom;
	}
	
	public Categorie(String description, String nom) {
		super();
		this.description = description;
		this.nom = nom;
	}

	public Categorie() {
	}

	public int getIdCat() {
		return this.idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
