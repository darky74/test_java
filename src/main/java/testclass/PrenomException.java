package testclass;

public class PrenomException extends Exception {
	
	
	public PrenomException(String prenom) {
		System.out.println("Le prénom doit contenir au minimum 3 caractères et ne contenir que des lettres");
	}
}
