package fr.adaming.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.dao.ArticleDao;
import fr.adaming.dao.CategorieDao;
import fr.adaming.dao.CommandeDao;
import fr.adaming.entity.Article;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Commande;

@ManagedBean
@RequestScoped
public class CommandeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Commande commande;
	private Categorie categorie;
	
	@EJB
	private CommandeDao commandeDao;
	@EJB
	private ArticleDao articleDao;
	@EJB
	private CategorieDao categorieDao;
	
	public Commande getCommande() {
        return commande;
    }
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	// Initialisation de l'entité
    public CommandeBean() {
    	commande = new Commande();
    	categorie = new Categorie();/*categorieDao.getFirstCategorie();*/
    	//test
//    	categorie.setId(1);	//TODO supprimer et ajouter la modif categorie par vue
//    	categorie.setLibelle("Homme");
    	System.out.println("########################Talk to me !");
    }
    
    public List<String> getCategoriesName() {
    	return commandeDao.getAllCategoriesName();
    }
    
    public List<Categorie> getCategories() {
    	return commandeDao.getAllCategories();
    }
    
    public List<Article> getArticlesByCategorie() {
    	if(categorie.getLibelle().equals("")||categorie.getLibelle()==null)
    		return new ArrayList<Article>();
    	List<Article> l = articleDao.findArticleByCategorie(categorie);
    	if(l==null)
    		return new ArrayList<Article>();
    	return l;
    }
    
    public Categorie getCategorieByLibelle(String libelle) {
    	return categorieDao.getCategorieByLibelle(libelle);
    	
    }

}
