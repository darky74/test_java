package testclass;

public class Post {
	
	
	private String [][] post = new String [3][2];
	private String titre;
	private String message;
	
	
	
	public Post() {
		
	}
	public String[][] getPost() {
		return post;
	}
	public void setPost(String[][] post) {
		this.post = post;
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
	
	
	
}

