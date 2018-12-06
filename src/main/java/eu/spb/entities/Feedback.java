package eu.spb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id_feed;
	private String description;
	private Date datefeed;
	
	
	@ManyToOne
	@JoinColumn(name="event")
	private Evenement event;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	
	public long getId_feed() {
		return id_feed;
	}
	public void setId_feed(long id_feed) {
		this.id_feed = id_feed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatefeed() {
		return datefeed;
	}
	public void setDatefeed(Date datefeed) {
		this.datefeed = datefeed;
	}
	
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Feedback(long id_feed, String description, Date datefeed,Evenement event, User user) {
		super();
		this.id_feed = id_feed;
		this.description = description;
		this.datefeed = datefeed;
		this.event=event;
		this.user=user;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
