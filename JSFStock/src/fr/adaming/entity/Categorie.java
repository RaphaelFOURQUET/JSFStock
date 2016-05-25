/**
 * 
 */
package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Categorie {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public int getId() {
		return id;
	}
	
	public Categorie() {
		
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	

}
