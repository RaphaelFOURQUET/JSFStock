package fr.adaming.beans;

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
public class InscriptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Client client;
	
	@EJB
	private ClientDao clientDao;
	
	// Initialisation de l'entité client
    public InscriptionBean() {
        client = new Client();
    }
    
    // Méthode d'action appelée lors du clic sur le bouton du formulaire d'inscription
    public void inscrire() {
        clientDao.addClient(client);
        FacesContext.getCurrentInstance().addMessage( null, new FacesMessage( "Succès de l'inscription !" ) );
//        try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }


    public Client getClient() {
        return client;
    }

}
