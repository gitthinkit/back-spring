package eu.spb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


<<<<<<< HEAD

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
=======
@Entity
public class Convention implements Serializable {
	
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
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
=======
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
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
<<<<<<< HEAD
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
=======
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDate(Date datedeb) {
		this.datedeb = datedeb;
	}
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	public String getConditionconv() {
		return conditionconv;
	}
	public void setConditionconv(String conditionconv) {
		this.conditionconv = conditionconv;
	}

<<<<<<< HEAD
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
	
=======
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

>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
	
}
