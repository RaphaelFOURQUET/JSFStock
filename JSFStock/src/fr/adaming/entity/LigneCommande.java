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
public class LigneCommande {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Article article;
	private int quantite;
	private double prixTotal;
	
	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
		this.prixTotal = article.getPrixUnitaire()*quantite;
	}
	
	public double getPrixTotal() {
		return prixTotal;
	}
	
//	public void setPrixTotal(double prixTotal) {
//		this.prixTotal = prixTotal;
//	}
	
	public int getId() {
		return id;
	}
	
	

}
