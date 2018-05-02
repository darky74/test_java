package testclass;

import java.time.DateTimeException;

public class User {
	
	/**
	 * Déclaration des variables (attributs), leur type, leur portée
	 */

	private String prenom;
	private String nom;
	private String naissance;
	
	public String regexName = "^[A-Za-z]{3,}$";
	public String regexDate = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$";
	
	
	
	
	

	public String getLevel() {
		return "0";

	}

	
	/**
	 * Créeation de constructeurs avec et sans paramètres
	 */

	public User () 
			throws PrenomException
	{
	}

	public User(String newPrenom, String newNom) {
		System.out.println("Création d'un User avec des paramètres");
		prenom = newPrenom;
		nom = newNom;

	}

	public User(String newPrenom, String newNom, String newNaissance) 
			throws PrenomException, NomException, DateException
	{
		if (!newPrenom.matches(regexName)) {
			throw new PrenomException(prenom);
		}
		
		if (!newNom.matches(regexName) ) {
			throw new NomException(nom);
		}
		if (!newNaissance.matches(regexDate)) {
			throw new DateException(naissance);		}
		
		prenom = newPrenom;
		nom = newNom;
		naissance = newNaissance;

	}

	
	/**
	 * Création de getters (accesseurs) et setters (mutateurs)
	 * Raccourci = dans la page: aller dans source -> Generate getters and setters
	 * déclarer les paramètres et leur type
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws PrenomException{
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom)throws NomException {
		this.nom = nom;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance)  throws DateException{
		this.naissance = naissance;
	}


}
