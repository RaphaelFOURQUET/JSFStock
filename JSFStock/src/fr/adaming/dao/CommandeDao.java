/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class CommandeDao {
	
	@PersistenceContext(unitName = "MySQL")
	private EntityManager em;
	
	public void addCommande(Commande commande) {
		if(commande != null)
			em.persist(commande);
	}
	
	public void deleteCommande(Commande commande) {
		em.remove(commande);
	}
	
	public void editCommande() {
		//TODO
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getSingleResult(Query query) {
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Commande findCommande(int id) {
		// trouver commande en base
		Query q = em.createNamedQuery("findCommande");
		q.setParameter("id", id);
				
		return getSingleResult(q);
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> findCommandeByClient(Client client) {
		// trouver commande en base
		Query q = em.createQuery(
				"select distinct c from Commande c where c.createur=:client");
		q.setParameter("client", client);
				
		return q.getResultList();
	}
	
	public int countCommandesByUtilisateur(Client client) {

		Query q = em.createQuery("select count(c) from Commande c where c.createur=:client");
		q.setParameter("client", client);

		int res = (int) (long) (Long) q.getSingleResult();

		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAllCategoriesName() {
		Query q = em.createQuery("select c.libelle from Categorie c");
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories() {
		Query q = em.createQuery("select c from Categorie c");
		
		return q.getResultList();
	}

}
