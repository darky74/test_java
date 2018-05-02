package testclass;

import java.util.Date;

public class Worker extends Personne implements Salary {
	
	protected int salaire;
	protected  int dureeContrat;
	
	protected boolean allerBosser;
	
	
	public Worker(String prenom, String nom, String dateNaissance, int dureeContrat, int salaire) throws PrenomException, NomException 
	{
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setDateNaissance(dateNaissance);
		this.dureeContrat = dureeContrat;
		this.salaire = salaire;
	}
	
	
	protected void travailler() {
		
		allerBosser = true;
		System.out.println("Allez va bosser feignant!!!!");
		
	}
	
	
	
	public void getPaiement() {
		if (allerBosser = true) {
			System.out.println("Vous allez percevoir votre salaire d'un montant de: "+salaire+"pesos!");
			
		}
	}


	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 3;
	}

}
