package eu.spb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Convention implements Serializable {
	
	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue
	private long id_conv;
	private String titre;
	private String tel;
	private String fax;
	private String site_web;
	private String email;
	private Date datedeb;
	private Date datefin;
	private String conditionconv;
	
	public String getSite_web() {
		return site_web;
	}

	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private long fornisseur;
	private String description;
	private long categorie;

	
	
	    @ManyToOne
	    @JoinColumn(name = "id_fornisseur")
	    public long getId_fornisseur() {
	        return fornisseur;
	  }

	    public void setId_fornisseur(long fornisseur) {
	        this.fornisseur = fornisseur;
	    }
	
	
	    
	    @ManyToOne
	    @JoinColumn(name = "id_cat")
	    public long getCategorie() {
	        return categorie;
	  }

	    public void setCategorie(long categorie) {
	        this.categorie = categorie;
	    }
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public long getId_conv() {
		return id_conv;
	}
	public void setId_conv(long id_conv) {
		this.id_conv = id_conv;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDate(Date datedeb) {
		this.datedeb = datedeb;
	}
	public String getConditionconv() {
		return conditionconv;
	}
	public void setConditionconv(String conditionconv) {
		this.conditionconv = conditionconv;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public Convention(long id_conv, String titre, String tel, String fax, String site_web,
			String email, Date datedeb,Date datefin, String conditionconv, long fornisseur,
			String description, long categorie) {
		super();
		this.id_conv = id_conv;
		this.titre = titre;
		this.tel = tel;
		this.fax = fax;
		this.site_web=site_web;
		this.email = email;
		this.datedeb = datedeb;
		this.datefin=datefin;
		this.conditionconv = conditionconv;
		this.fornisseur = fornisseur;
		this.description = description;
		this.categorie = categorie;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	
}
