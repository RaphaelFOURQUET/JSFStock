/**
 * 
 */
package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entity.Categorie;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class CategorieDao {
	
	@PersistenceContext(unitName = "MySQL")
	private EntityManager em;
	
	public Categorie getFirstCategorie() {
		
		Query q = em.createQuery("select c from Categorie c");
		
		return (Categorie) q.getResultList().get(0);
		
	}
	
	public void addCategorie(Categorie categorie) {
		em.persist(categorie);
	}
	
	public void deleteCategorie(Categorie categorie) {
		em.remove(categorie);
	}
	
	public Categorie getCategorieByLibelle(String libelle) {
		// trouver commande en base
		Query q = em.createQuery(
			"select c from Categorie c where c.libelle=:libelle");
		q.setParameter("libelle", libelle);
						
		return (Categorie) q.getSingleResult();
	}

}
