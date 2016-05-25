/**
 * 
 */
package fr.adaming.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.dao.ClientDao;
import fr.adaming.entity.Client;

/**
 * @author INTI-0332
 *
 */
@ManagedBean
@RequestScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Client client;
	
	@EJB
	private ClientDao clientDao;
	
	public Client getClient() {
        return client;
    }
	
	// Initialisation de l'entité client
    public ClientBean() {
    	client = (Client) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("client");
    }

}
