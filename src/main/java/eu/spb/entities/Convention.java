package eu.spb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
public class Convention implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idConv")
	private int idConv;

	private String conditionconv;

	@Temporal(TemporalType.DATE)
	private Date datedeb;

	@Temporal(TemporalType.DATE)
	private Date datefin;

	private String description;

	private String titre;

	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name="fournisseur")
	private Fournisseur fournisseur;
	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Convention(int id_conv, String titre, String description, Date datedeb, Date datefin, String conditionconv,
			Fournisseur fournisseur, Categorie categorie) {
		super();
		this.idConv = id_conv;
		this.titre = titre;
		this.description = description;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.conditionconv = conditionconv;
		this.fournisseur = fournisseur;
		this.categorie = categorie;
	}

	public int getIdConv() {
		return idConv;
	}

	public void setIdConv(int idConv) {
		this.idConv = idConv;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getConditionconv() {
		return conditionconv;
	}
	public void setConditionconv(String conditionconv) {
		this.conditionconv = conditionconv;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
