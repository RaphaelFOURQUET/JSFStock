/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entity.Article;
import fr.adaming.entity.Categorie;

/**
 * @author INTI-0332
 *
 */
@Stateless
public class ArticleDao {
	
	@PersistenceContext(unitName = "MySQL")
	private EntityManager em;
	
	public void addArticle(Article article) {
		if(article != null)
			em.persist(article);
	}
	
	public void deleteArticle(Article article) {
		em.remove(article);
	}
	
	public void editArticle() {
		//TODO
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> findArticleByCategorie(Categorie categorie) {
		if(categorie.getLibelle().equals(""))
			return null;
			
		Query q = em.createQuery("select a from Article a where a.categorie=:categorie");
		q.setParameter("categorie", categorie);
		
		return q.getResultList();
	}

}
