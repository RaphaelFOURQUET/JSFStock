package fr.adaming.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.dao.ClientDao;
import fr.adaming.entity.Client;

@ManagedBean
@RequestScoped
public class ConnectionBean implements Serializable {

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
    public ConnectionBean() {
    	client = new Client();
    }
    
    public void connect() {
    	FacesContext f = FacesContext.getCurrentInstance();
    	//recuperer le client en BD avec email entré.
    	Client c = clientDao.findClientByEmail(client.getEmail());
    	if(c==null) {
    		this.client = new Client();
    		f.addMessage( null, new FacesMessage( "Unable to connect !"));
    	}
    	else {
    		if(this.client.getPassword().equals(c.getPassword())) {
    			this.client = c;
    			f.addMessage( null, new FacesMessage( "Conecté !" ) );
    			f.getExternalContext().getSessionMap().put("client", this.client);
//    			f.getExternalContext().getSessionMap().put("clientId", this.client.getId());
    			try {
					f.getExternalContext().redirect("clientVue.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		} else {
    			f.addMessage( null, new FacesMessage( "Password incorrect" ) );
    		}
    	}
    }

}
