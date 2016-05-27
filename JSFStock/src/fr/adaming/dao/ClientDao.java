/**
 * 
 */
package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entity.Client;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class ClientDao {
	
	@PersistenceContext(unitName = "MySQL")
	private EntityManager em;
	
	public void addClient(Client client) {
		if(client != null)
			em.persist(client);
	}

	@SuppressWarnings("unchecked")
	private <T> T getSingleResult(Query query) {
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Client findClientByEmail(String email) {
		// trouver client en base
		Query q = em.createNamedQuery("findClientByEmail");
		q.setParameter("email", email);
		
		return getSingleResult(q);
	}

	public Client findClient(Integer id) {
		if (id == null) {
			return null;
		}
		Client client = em.find(Client.class, id);
		return client;
	}
	
	public void editClient() {
		//TODO
	}
	
	public void deleteClient(Client client) {
		em.remove(client);
	}
	
	

}
