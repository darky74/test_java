package testclass;

public class Moderateur extends User {
	
	private String level;
	
	public Moderateur() throws PrenomException, NomException, DateException {
		
	}
	
	public Moderateur(String prenom, String nom, String naissance, String level)
			throws PrenomException, NomException, DateException
	{
		super(prenom, nom, naissance);
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	
}
