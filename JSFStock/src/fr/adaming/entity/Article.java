/**
 * 
 */
package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Article {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Categorie categorie;
	private String designation;
	private String description;
	private double prixUnitaire = 0;
	private int qteStock;
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public int getQteStock() {
		return qteStock;
	}
	
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	public int getId() {
		return id;
	}
	
	public Article() {
		
	}

	public Article(Categorie categorie, String designation, String description, double prixUnitaire, int qteStock) {
		super();
		this.categorie = categorie;
		this.designation = designation;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}
	
	

}
