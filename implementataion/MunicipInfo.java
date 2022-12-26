import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe est l'API du service de MunicipInfo.
 */
public class MunicipInfo implements Serializable {


	public ArrayList<String> consummerCodes;

	public boolean validateConsommateur(String code) {
		// Appel MunicipInfo: get-consommateur(code)
		Consomateur consomateur = getConsommateur(code);
		AccountController accountController = new AccountController();
		return true;
	}
	/**
	 * Cette fonction simule l'appel à get-consommateur(code)
	 * @return {@link Consomateur}
	 */
	private Consomateur getConsommateur(String code) {
		var consomateur = new Consomateur();

		consomateur.code = "232";
		consomateur.nom = "replastic";
		consomateur.adresse = "";
		consomateur.email = "info@replastic.com";
		consomateur.telephone = "";
		consomateur.details = "Nous transformons tout vos plastiques et verres jetées en bouteille prêt à être utilisé pour conserveau votre eau et vos brevages favoris";
		consomateur.type_dechets = new String[] { "plastique", "verre" };
		consomateur.capacite = "100 tonnes";

		return consomateur;
	}

	private class Consomateur {
		String code;
		String nom;
		String adresse;
		String email;
		String telephone;
		String details;
		String[] type_dechets;
		String capacite;
	}

	/**
	 * Cette fonction simule la verification de mot de passe.
	 * 
	 */
	public Boolean verifyPassword(String account, String password1, String password2){
		return password1 == password2;
	}


	/**
	 * Cette fonction simule l'envoi de message.
	 * 
	 */
	public void post_message(String message){
		System.out.println(message);
	}

	/**
	 * Cette fonction simule l'affiche de l'etat des lots de dechets municipaux.
	 * 
	 */
	public void afficher_lots(){
		var lots = new ArrayList<Lot>();

		var lot_1 = new Lot();
		System.out.println("premier lot");
		lot_1.cout = 200.0;
		lot_1.state = "livrason";
		lot_1.date_livraison = "2021/08/02";
		lot_1.date_ramassage = "2021/09/03";
		lot_1.number = "f200";
		afficher_lot(lot_1);
		System.out.println("========================");

		System.out.println("deuxieme lot");
		var lot_2 = new Lot();
		lot_2.cout = 140.0;
		lot_2.state = "ramassage";
		lot_2.date_livraison = "2021/10/02";
		lot_2.date_ramassage = "2021/12/03";
		lot_2.number = "f2vda00";
		afficher_lot(lot_2);
		System.out.println("========================");

		System.out.println("troisieme lot");
		var lot_3 = new Lot();
		lot_3.cout = 430.0;
		lot_3.state = "livrason";
		lot_3.date_livraison = "2022/08/02";
		lot_3.date_ramassage = "2022/09/03";
		lot_3.number = "f2we00";
		afficher_lot(lot_3);

	}
	/**
	 * Cette fonction simule l'affiche de l'etat de 1 lot de dechets.
	 * 
	 */
	public void afficher_lot(Lot lot){
		System.out.println("le state est " + ":" +  lot.state);
		System.out.println("le date_livraison est " + ":" +  lot.date_livraison);
		System.out.println("le date_ramassage est " + ":" +  lot.date_ramassage);
		System.out.println("le numero est  " + ":" +  lot.number);
	}


	private class Lot  {
		private String number;
		private String state;
		private String date_ramassage;
		private String date_livraison;
		private Double cout;
	}

}