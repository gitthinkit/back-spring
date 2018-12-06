package eu.spb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evenement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id_event;
	private String titre;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date datedeb;
	@Temporal(TemporalType.DATE)
	private Date datefin;
	
	@ManyToOne
	@JoinColumn(name="convention")
	private Convention convention;
	
	@ManyToOne
	@JoinColumn(name="media")
	private Media media;

	
	public long getId_event() {
		return id_event;
	}
	public void setId_event(long id_event) {
		this.id_event = id_event;
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
	
	public Convention getConvention() {
		return convention;
	}
	public void setConvention(Convention convention) {
		this.convention = convention;
	}

	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Evenement(long id_event,String titre, String description, Date datedeb, Date datefin,Convention convention,  Media media) {
		super();
		this.id_event = id_event;
		this.titre=titre;
		this.description = description;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.convention=convention;
		this.media = media;
		
	}
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Evenement(long id_event,String titre, String description) {
		super();
		this.id_event = id_event;
		this.titre=titre;
		this.description = description;
	
	}
	
}
