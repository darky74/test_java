package testclass;

import java.time.DateTimeException;
import java.util.ArrayList;

public class User extends Personne implements Relation {
	
	/**
	 * Déclaration des variables (attributs), leur type, leur portée
	 */

	private String prenom;
	private String nom;
	private String naissance;
	private String pseudo;
	private int numUser;
	ArrayList<Integer> friendList = new ArrayList<Integer>();
	
	public int getNumUser() {
		return numUser;
	}

	public void setNumUser(int numUser) {
		this.numUser = numUser;
	}

	public String regexName = "^[A-Za-z]{3,}$";
	public String regexDate = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\/(1[012]|0?[1-9])\\/((?:19|20)\\d{2})\\s*$";
	
	
		
	public void idFriend(int numAmi) {
		friendList.add(numAmi);
	}

	public int getLevel() {
		return 0;

	}
	
	public void seConnecter() {
		
	}
	
	public void seDeconnecter() {
		
	}

	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	public User(String newPrenom, String newNom, String newNaissance, ArrayList<Integer> newFriendList) 
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
		friendList = newFriendList;

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

	public void AjouterPersonne() {
		// TODO Auto-generated method stub
		
	}


}
