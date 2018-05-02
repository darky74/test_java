package testclass;

/**
 * Instancier l'objet scanner pour utiliser l'entrée standart clavier System.in
 */
import java.util.Scanner;
import java.util.regex.*;

public class testclass {

	/**
	 * La méthode main est la porte d'entrée de l'application On y instancie la
	 * classe dans laquelle on travaille pour l'utiliser
	 * 
	 * @param args
	 * @throws NomException 
	 * @throws DateException 
	 */

	public static void main(String[] args) throws PrenomException, DateException, NomException {
		// TODO Auto-generated method stub
		testclass tesctclass = new testclass();
	}

	/**
	 * Déclaration des variables, type, portée
	 */

	private String posts;
	private User[] users = new User[3];
	private int numUser, numPost, numMsg = 0;
	private char reponse = 'o';
	private char condition;
	private char condition2;
	private String prenom;
	private String nom;
	private String naissance;
	private String level;

	/**
	 * Entrée clavier standart (équivalent du prompt en JS)
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * On instancie la classe User avec unnouvel objet user
	 */
	User currentUser;
	User user;
	Moderateur moderateur;

	Post post = new Post();

	/**
	 * Déclaration d'une méthode qui a LE MEME NOM QUE LA CLASSE qui est rappelés
	 * dans la main, on y appelle et construit toute notre appli
	 * @throws DateException 
	 */

	public testclass() throws DateException, PrenomException, NomException {

		/**
		 * Création d'un utilisateur On réckupère les valeurs via sc.nexLine() dans les
		 * setters et on les insère dans un tableau via les getters
		 */

		createUser();

	}

	private void createUser() throws PrenomException,NomException, DateException {

		condition = 'o';
		while (condition != '1' && condition != '2') {
			System.out.println("Utilisateur tapez 1 \nModérateur tapez 2");
			condition = sc.nextLine().charAt(0);

			if (condition == '1') {

				System.out.println("Veuillez entrer votre prénom: ");
				prenom = (sc.nextLine());
				System.out.println("Veuillez entrer votre nom: ");
				nom = (sc.nextLine());
				System.out.println("Veuillez entrer votre date de naissance: ");
				naissance = (sc.nextLine());
				try {

					currentUser = new User(prenom, nom, naissance);
					users[numUser] = currentUser;

				} catch (PrenomException e) {
					createUser();
				} catch (NomException e) {
					createUser();
					e.printStackTrace();
					
				} catch (DateException e) {
					createUser();
					e.printStackTrace();
				}

			} else if (condition == '2') {

				System.out.println("Modérateur classique: tapez1 \nModérateur avancé: tapez 2");
				level = sc.nextLine();
				System.out.println("Veuillez entrer votre prénom: ");
				prenom = sc.nextLine();
				System.out.println("Veuillez entrer votre nom: ");
				nom = sc.nextLine();
				System.out.println("Veuillez entrer votre date de naissance: ( au format jj/mm/aaa");
				naissance = sc.nextLine();
				try {
					moderateur = new Moderateur(prenom, nom, naissance, level);
					users[numUser] = moderateur;

				} catch (PrenomException e) {
					createUser();
				} catch (NomException e) {
					createUser();
					e.printStackTrace();
				}

			}

		}

		numUser++;
		showMenu();
	}

	/**
	 * @throws NomException 
	 * @throws PrenomException 
	 * @throws DateException 
	 * 
	 */
	public void showMenu() throws PrenomException, NomException, DateException  {
		while (reponse == 'o') {

			/**
			 * Création du menu de navigation une A faire en class par la suite
			 */

			System.out.println("Pour afficher votre profil: Tapez 1");
			System.out.println("Pour modifier vos infos: Tapez 2");
			System.out.println("Pour écrire un message: Tapez 3");
			System.out.println("Pour afficher vos messages: Tapez 4");
			System.out.println("Pour ajouter un ami: Tapez 5");
			System.out.println("Pour afficher vos amis: Tapez 6");

			if (condition == '2' && this.users[numUser - 1].getLevel().equals("1")
					|| this.users[numUser - 1].getLevel().equals("2")) {
				System.out.println("pour supprimer un message: Tapez 7");

				if (this.users[numUser - 1].getLevel().equals("2")) {
					System.out.println("pour supprimer un utilisateur: Tapez 8");
				}
			}

			reponse = sc.nextLine().charAt(0);

			switch (reponse) {
			case '1':

				showProfile();
				break;

			case '2':

				updateProfile();

				break;

			case '3':

				newMessage();
				break;

			case '4':

				showMessage();
				break;

			case '5':

				createUser();

				break;

			case '6':

				showFriends();
				break;

			default:
				System.out.println("Faites un chois de 1 à 6");
			}
			while (reponse != 'o' && reponse != 'n') {
				System.out.println("Voulez revenir au menu?  (o/n)");
				reponse = sc.nextLine().charAt(0);
			}

		}

		System.out.println("Au revoir…");
	}

	public void showProfile() {

		System.out.println("Nom: " + this.users[0].getNom() + "\nPrénom: " + this.users[0].getPrenom());

	}

	public void updateProfile() {

		System.out.println("Renseignez votre prénom : ");
		prenom = sc.nextLine();
		System.out.println("Renseignez votre nom de famille: ");
		nom = sc.nextLine();
		System.out.println("Renseignez votre date de naissance: ");
		naissance = sc.nextLine();

		try {
			currentUser = new User(prenom, nom, naissance);

		} catch (PrenomException e) {
			updateProfile();
		} catch (NomException e) {
			updateProfile();
			e.printStackTrace();
		} catch (DateException e) {
			updateProfile();
			e.printStackTrace();
		}
		users[numUser] = currentUser;
		System.out.println("Votre prifil a bien été édité");
	}

	public void newMessage() {

		if (numPost < post.getPost().length) {

			System.out.println("Saisir li titre du message");
			this.post.setTitre(sc.nextLine());
			System.out.println("Saississez votre message");
			this.post.setMessage(sc.nextLine());

			this.post.getPost()[numPost][0] = this.post.getTitre();
			this.post.getPost()[numPost][1] = this.post.getMessage();

			numPost++;

		} else {

			System.out.println("trop de messages");
		}
	}

	public void showMessage() {
		System.out.println("Voici vos messages:");
		System.out.println("--------------------");

		for (int i = 0; i < this.post.getPost().length; i++) {

			if (this.post.getPost()[i][1] != null) {
				System.out.println("Auteur: " + users[i].getPrenom());
				System.out.println(
						"Titre: " + this.post.getPost()[i][0] + "\n" + "Message: " + this.post.getPost()[i][1]);
			}
		}
	}

	public void showFriends() {
		System.out.println("Voici la liste de vos amis: ");

		for (int i = 1; i < users.length; i++) {
			if (users[i] != null) {
				System.out.println(users[i].getNom());
				System.out.println("");
			}
		}
		if (numUser < 1) {
			System.out.println("Vous n'avez pas d'amis!!!");
		}

	}

}