package tp3.example.tp3.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;

@Entity
public class Address {
	@javax.persistence.Id
	@Id
	@GeneratedValue
	private Long id;
	
	private Date creation;
	private String content;
	private String auteur;
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
