package testclass;

public class Moderateur extends User implements Salary{
	
	private int level;
	private String salaire;
	
	public Moderateur() throws PrenomException, NomException, DateException {
		
	}
	
	public Moderateur(String prenom, String nom, String naissance, int level)
			throws PrenomException, NomException, DateException
	{
		super(prenom, nom, naissance);
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void getPaiement() {
		System.out.println("Merci d'avoir joué avec nous, Voici 2 tickets restos!");
		
	}
	
	public void suppMessage() {
		System.out.println("Votre message a bien été supprimé");
	}

	
}
