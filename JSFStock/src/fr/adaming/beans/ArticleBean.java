/**
 * 
 */
package fr.adaming.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.dao.ArticleDao;
import fr.adaming.entity.Article;

/**
 * @author INTI-0332
 *
 */
@ManagedBean
@RequestScoped
public class ArticleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Article article;
	
	@EJB
	private ArticleDao articleDao;
	
	public Article getArticle() {
		return article;
	}
	
	public ArticleBean() {
		article = new Article();
	}

}
