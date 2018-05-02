package testclass;

import java.util.Date; 
public abstract class Personne {
	
	protected String nom;
	protected String prenom;
	protected String dateNaissance;
	
	abstract public int getLevel();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws NomException {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws PrenomException {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
}
