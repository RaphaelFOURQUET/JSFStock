/**
 * 
 */
package fr.adaming.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author INTI-0332
 *
 */
@Entity
public class Adresse {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String rue;
	private int codePostal;
	private String ville;
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public int getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}
	
	public Adresse() { }

	public Adresse(String rue, int codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	

}
