package testclass;

public class Post {
	
	
	
	private String titre;
	private String message;
	private String expediteur;
	private String destinataire;
	
	
	
	public Post(String newTitre, String newMessage, String newExpediteur, String newDestinataire) {
		
		titre = newTitre;
		message = newMessage;
		expediteur = newExpediteur;
		destinataire = newDestinataire;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getExpediteur() {
		return expediteur;
	}



	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}



	public String getDestinataire() {
		return destinataire;
	}



	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	
	
	
	
}

