package eu.spb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Media implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id_media;
	private String path;
	public long getId_media() {
		return id_media;
	}
	public void setId_media(long id_media) {
		this.id_media = id_media;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Media(long id_media, String path) {
		super();
		this.id_media = id_media;
		this.path = path;
	}
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
