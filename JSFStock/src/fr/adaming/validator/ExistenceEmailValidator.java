/**
 * 
 */
package fr.adaming.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.adaming.dao.ClientDao;

/**
 * @author INTI-0332
 *
 */
@ManagedBean
@RequestScoped
public class ExistenceEmailValidator implements Validator {

	private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée";

	@EJB
	private ClientDao clientDao;

	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
		/* Récupération de la valeur à traiter depuis le paramètre value */
		String email = (String) value;

		if ( clientDao.findClientByEmail(email) != null ) {
			/*
			 * Si une adresse est retournée, alors on envoie une exception
			 * propre à JSF, qu'on initialise avec un FacesMessage de
			 * gravité "Erreur" et contenant le message d'explication. Le
			 * framework va alors gérer lui-même cette exception et s'en
			 * servir pour afficher le message d'erreur à l'utilisateur.
			 */
			throw new ValidatorException(
					new FacesMessage( FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE_DEJA, null ) );
		}

	}

}
