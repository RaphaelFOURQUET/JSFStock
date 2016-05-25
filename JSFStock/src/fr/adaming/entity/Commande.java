/**
 * 
 */
package fr.adaming.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.adaming.entity.LigneCommande;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Commande {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dateCommande;
	private double montantTotal;
	@OneToMany
	List<LigneCommande> lignes = new ArrayList<LigneCommande>();
	
	public Date getDateCommande() {
		return dateCommande;
	}
	
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public double getMontantTotal() {
		return montantTotal;
	}
	
	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	public int getId() {
		return id;
	}
	
	public List<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public Commande() {
		
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}
	
	
	
	

}
