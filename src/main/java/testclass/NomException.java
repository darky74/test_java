package testclass;

public class NomException extends Exception{
	
	public NomException(String nom) {
		System.out.println("Le nom doit contenir au minimum 3 caractères et ne contenir que des lettres");
	}
}
