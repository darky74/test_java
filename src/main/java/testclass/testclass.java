package testclass;

/**
 * Instancier l'objet scanner pour utiliser l'entrée standart clavier System.in
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
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

	private int numUser, numPost, numMsg = 0;
	private char reponse = ' ';
	private char condition;
	private char condition2;
	private String prenom;
	private String nom;
	private String naissance;
	private int level;
	private String login;
	private String login2;

	private String titre;
	private String message;
	private String expediteur;
	private String destinataire;

	boolean userConnect = false;
	
	ArrayList<Integer>friendList = new ArrayList<Integer>();
	ArrayList<User> listUsers = new ArrayList<User>();
	ArrayList<Post> listMessages = new ArrayList<Post>();

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

	Post post;

	/**
	 * Déclaration d'une méthode qui a LE MEME NOM QUE LA CLASSE qui est rappelés
	 * dans la main, on y appelle et construit toute notre appli
	 * 
	 * @throws DateException
	 */

	public testclass() throws DateException, PrenomException, NomException {

		/**
		 * Création d'un utilisateur On réckupère les valeurs via sc.nexLine() dans les
		 * setters et on les insère dans un tableau via les getters
		 */

		auth();

	}

	private void createUser() throws PrenomException, NomException, DateException {

		condition = 'o';
		while (condition != '1' && condition != '2') {
			System.out.println("Utilisateur tapez 1 \nModérateur tapez 2");
			condition = sc.nextLine().charAt(0);

			if (condition == '1') {

				System.out.println("Veuillez entrer votre prénom: ");
				prenom = (sc.nextLine());
				System.out.println("Veuillez entrer votre nom: ");
				nom = (sc.nextLine());
				System.out.println("Veuillez entrer votre date de naissance: ( au format jj/mm/aaaa)");
				naissance = (sc.nextLine());
				try {

					currentUser = new User(prenom, nom, naissance, friendList);
					listUsers.add(currentUser);

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
				level = Integer.parseInt(sc.nextLine());
				System.out.println("Veuillez entrer votre prénom: ");
				prenom = sc.nextLine();
				System.out.println("Veuillez entrer votre nom: ");
				nom = sc.nextLine();
				System.out.println("Veuillez entrer votre date de naissance: ( au format jj/mm/aaaa)");
				naissance = sc.nextLine();
				try {
					moderateur = new Moderateur(prenom, nom, naissance, level,friendList);
					listUsers.add(moderateur);

					for (int i = 0; i < listUsers.size(); i++) {
						System.out.println("donnée à l'indice " + i + " = " + listUsers.get(i).getPrenom());
					}

				} catch (PrenomException e) {
					createUser();
				} catch (NomException e) {
					createUser();
					e.printStackTrace();
				}

			}

		}

		numUser++;
		reponse = 'o';
		showMenu();
	}

	/**
	 * @throws NomException
	 * @throws PrenomException
	 * @throws DateException
	 * 
	 */
	public void showMenu() throws PrenomException, NomException, DateException {
		reponse = 'o';
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
			System.out.println("Pour sortir: Tapez 7");

			if (condition == '2' && this.listUsers.get(numUser - 1).getLevel() == 1
					|| this.listUsers.get(numUser - 1).getLevel() == 2) {
				System.out.println("pour supprimer un message: Tapez 7");

				if (this.listUsers.get(numUser - 1).getLevel() == 2) {
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

				addFriend();

				break;

			case '6':

				showFriends();
				break;

			case '7':
				exit();
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
		connection();
	}

	public void connection() throws PrenomException, NomException, DateException {

		
				System.out.println("Quel est votre prénom?");
				login = sc.nextLine();
				System.out.println("Quel est votre nom?");
				login2 = sc.nextLine();
				reponse = 'o';
				userConnect = false;
				for (int i = 0; i < listUsers.size(); i++) {
					if (listUsers.get(i).getPrenom().equals(login) && listUsers.get(i).getNom().equals(login2)) {

						System.out.println("Bienvenue à toi " + listUsers.get(i).getPrenom()+" "+ listUsers.get(i).getNom());
						userConnect = true;
						user = currentUser;
						break;
					}
				}

				if (userConnect) {

					showMenu();
				} else {
					System.out.println("Vous n'êtes pas inscrits");
					auth();
				}

		

		}
	
	public void auth() throws PrenomException, NomException, DateException {
		
		while (reponse != '1' && reponse != '2') {
			System.out.println("Pour vous connecter: tapez1 \nPour vous inscrire: Tapez 2");
			reponse = sc.nextLine().charAt(0);

		}
		if(reponse == '1') {
			connection();
		}
		else if (reponse == '2') {
			createUser();
		}
	}
	
	

	public void showProfile() {

		System.out.println("Nom: " + this.listUsers.get(numUser - 1).getNom() + "\nPrénom: "
				+ this.listUsers.get(numUser - 1).getPrenom());

	}

	public void updateProfile() throws PrenomException, NomException {

		System.out.println("Renseignez votre prénom : ");
		prenom = sc.nextLine();
		System.out.println("Renseignez votre nom de famille: ");
		nom = sc.nextLine();
		System.out.println("Renseignez votre date de naissance: ");
		naissance = sc.nextLine();

		listUsers.get(numUser - 1).setPrenom(prenom);
		listUsers.get(numUser - 1).setNom(nom);
		listUsers.get(numUser - 1).setDateNaissance(naissance);
		;

		System.out.println("Votre prifil a bien été édité");
	}

	public void newMessage() {

		if (numPost <= listMessages.size()) {

			System.out.println("Saisir le titre du message");
			titre = sc.nextLine();
			System.out.println("Saisir votre message");
			message = sc.nextLine();
			expediteur = currentUser.getPrenom();
			destinataire = currentUser.getNaissance();

			post = new Post(titre, message, expediteur, destinataire);
			listMessages.add(post);

			numPost++;

		} else {

			System.out.println("trop de messages");
		}
	}

	public void showMessage() {
		System.out.println("Voici vos messages:");
		System.out.println("--------------------");

		for (int i = 0; i < listMessages.size(); i++) {

			if (this.listMessages.get(i).getMessage() == null) {

				System.out.println("La messagerie est vide");
			} else {
				System.out.println("Auteur: " + listUsers.get(i).getPrenom());
				System.out.println("Titre: " + this.listMessages.get(i).getMessage() + "\n" + "Message: "
						+ this.listMessages.get(i).getMessage());

			}
		}
	}
	
	private void addFriend() throws PrenomException, NomException, DateException {

		condition = 'o';
		while (condition != '1' && condition != '2') {
			System.out.println("Utilisateur tapez 1 \nModérateur tapez 2");
			condition = sc.nextLine().charAt(0);

			if (condition == '1') {

				System.out.println("Veuillez entrer votre prénom: ");
				prenom = (sc.nextLine());
				System.out.println("Veuillez entrer votre nom: ");
				nom = (sc.nextLine());
				System.out.println("Veuillez entrer votre date de naissance: ( au format jj/mm/aaaa)");
				naissance = (sc.nextLine());
				try {

					user = new User(prenom, nom, naissance, friendList);
					listUsers.add(user);
					currentUser.idFriend(numUser);		
					user.idFriend(currentUser.getNumUser());
					System.out.println(currentUser.friendList);
					
					
					

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
				level = Integer.parseInt(sc.nextLine());
				System.out.println("Veuillez entrer votre prénom: ");
				prenom = sc.nextLine();
				System.out.println("Veuillez entrer votre nom: ");
				nom = sc.nextLine();
				System.out.println("Veuillez entrer votre date de naissance: ( au format jj/mm/aaaa)");
				naissance = sc.nextLine();
				try {
					moderateur = new Moderateur(prenom, nom, naissance, level,friendList);
					listUsers.add(moderateur);
					this.moderateur.idFriend(numUser);

					for (int i = 0; i < listUsers.size(); i++) {
						System.out.println("donnée à l'indice " + i + " = " + listUsers.get(i).getPrenom());
					}

				} catch (PrenomException e) {
					createUser();
				} catch (NomException e) {
					createUser();
					e.printStackTrace();
				}

			}

		}

		numUser++;
		reponse = 'o';
		showMenu();
	}

	public void showFriends() {
		System.out.println("Voici la liste de vos amis: ");

		for (int i = 1; i < listUsers.size(); i++) {
			if (listUsers.get(i) != null) {
				System.out.println(listUsers.get(i).getNom());
				System.out.println("");
			}
		}
		if (numUser < 1) {
			System.out.println("Vous n'avez pas d'amis!!!");
		}

	}

	public void exit() throws PrenomException, NomException, DateException {
		System.out.println("salut!");
		userConnect = false;
		currentUser = user;
		
		auth();

	}

}