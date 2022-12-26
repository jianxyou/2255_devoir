import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.io.Serializable;

/**
 * class Bin implement Serilalizable represente une poubelle (composte, ordure ou recyclage)
 * @author admin
 *
 */
public class Bin implements Serializable {
	String qrCode, name, type, address;

	// BinType binType; // todo: better design use this

	double fillLevel = 0; // Math.random(); //0.5;
	String currentComposition; //? hashmap<whatgarbage, proportion> , use proportion for scoreecono

	String usage;
	ArrayList<String> fillLevelHist = new ArrayList<String>(); //? with a certain time interval
	ArrayList<String> compositionHist = new ArrayList<String>(); //? prof said not need

	public Bin() {} // testing purposes constructor
	
	public Bin(String qrCode, String address) { // testing purposes constructor
		this.qrCode = qrCode;
		this.address = address;
	}
	/**
	 * constructeur genere initialise les point 
	 * @param qrCode specifique un bac 
	 * @param name nom du bac
	 * @param type type du bac
	 * @param address adress de l<emplacement du bac
	 */
	public Bin(String qrCode, String name, String type, String address) {
		this.qrCode = qrCode;
		this.name = name;
		this.type = type;
		this.address = address;

		// remove/replace this
		if (type.equals("RECYCLE")) {
			
			this.currentComposition = "10% paper, 30% plastic, 70% glass"; // placeholder for now (recycle example) // if compostbin: food waste , tree leaves, wood, plants, etc
		} else if (type.equals("COMPOST")) {
			this.currentComposition = "70% Food waste, 15% wood chips, 15% other";
		} else if (type.equals("TRASH")) {
			this.currentComposition = "Non-reusable waste";
		}
	}
	/**
	 * 
	 * @return retourne le code Qr
	 */
	public String getQRCode() { return qrCode; }
	/**
	 * 
	 * @return le nom du bac
	 */
	public String getName() { return name; }
	/**
	 * 
	 * @return le type du bac
	 */
	public String getType() { return type; }
	/**
	 * 
	 * @return l'adress du bac
	 */
	public String getAddress() { return address; }
	/**
	 * 
	 * @return le niveau de remplissage et double
	 */
	public double getFilledLevel() { return fillLevel; }
	/**
	 * 
	 * @return retourne la composition du bac
	 */
	public String getComposition() { return currentComposition; }
	/**
	 * met a jour les statut du bac ne prend rien en parametre comme le niveau de remplisage selon sa
	 * composition et type du bac
	 */
	public void updateStatus() {
		// realworld: get new data from bin sensors
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String timeOfUpdate = (dtf.format(now));

		// Fill level //? remove/replace
		fillLevelHist.add(0, now + ": " + fillLevel);
		fillLevel += Math.random();
		if (fillLevel > 1) {
			fillLevel = Math.random();
		}

		// Bin composition // remove/replace
		compositionHist.add(0, now + ": " + currentComposition);
		if (type.equals("RECYCLE")) {
			currentComposition = (Math.random() * 100 + "% plastic, " + Math.random() * 100 + "% paper, other.");
		} else if (type.equals("COMPOST")) {
			currentComposition = (Math.random() * 100 + "% food, " + Math.random() * 100 + "% leaves, other compostable material.");
		} else if (type.equals("TRASH")) {
			currentComposition = "Tissues, wrappers, other non-reusable waste.";
		}


		//usage =

	}

	// public void updateFillLevel() {} //? take args //? communicate with capteurs
	// public void updateComposition() {}
	// public void updateUsage() {}
	
}
