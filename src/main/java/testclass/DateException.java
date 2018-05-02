package testclass;

public class DateException extends Exception {
	public DateException(String naissance) {
		System.out.println("La date de naissance doit être au format suvant: jj/mm/aaa");
	}
}