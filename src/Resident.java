import java.util.ArrayList;
import java.io.Serializable;
/**
 * class resident et extend de Account et implement serialisation 
 * @author admin
 *
 */
public class Resident extends Account implements Serializable {
	
	private String lastName, firstName, email, telephone, address, password;
	// compteconfirme en 3 jours? boolean
	private ArrayList<Bin> registeredBins = new ArrayList<Bin>();

	// 3 Metrics
	private String CRTratio; // compost+reycle to trash ratio
	private String accumulationRate; // rate of how fast bins get filled
	private String ScoreEcono; // see metriques example


	/**
	 * constructeur
	 * @param lastName 
	 * @param firstName
	 * @param email
	 * @param telephone
	 * @param address
	 * @param password
	 * @param initialBin
	 */
	public Resident(String lastName, String firstName, String email, String telephone, String address, String password, Bin initialBin) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.password = password;
		this.registeredBins.add(initialBin);
	}
	/**
	 * ajouter un bac prend en parametre une Instance de Bin
	 * @param bin bac
	 */
	public void addBin(Bin bin) {
		registeredBins.add(bin);
	}
	/**
	 * change la valeur de nom de famille
	 * @param lastName
	 */
	public void setLastName(String lastName) { this.lastName = lastName; }
	/**
	 * change le prenom
	 * @param firstName
	 */
	public void setFirstName(String firstName) { this.firstName = firstName; }
	/**
	 * change adress couriel
	 * @param email
	 */
	public void setEmail(String email) { this.email = email; }
	/**
	 * change le telephone
	 */
	public void setTelephone(String telephone) { this.telephone = telephone; }
	/**
	 * change l'adress
	 * @param address
	 */
	public void setAddress(String address) { this.address = address; }
	/**
	 * change le password
	 * @param password
	 */
	public void setPassword(String password) { this.password = password; }


	/**
	 * enregistrer un bac 
	 * @return retourne une liste de instance Bin
	 */
	public ArrayList<Bin> getRegisteredBins() { return registeredBins; }
	/**
	 * 
	 * @return retourn le email
	 */
	public String getEmail() { return email; }
	/**
	 * 
	 * @return l'adress
	 */
	public String getAddress() { return address; }
	/**
	 * 
	 * @return le mot de pass
	 */
	public String getPassword() { return password; }
	/**
	 * 
	 * @return le prenom
	 */
	public String getFirstName() { return firstName; }

	
	public void updateCRTratio() {
		// calculate with formula
		// this.CRTratio =
	}

	public void updateAccumRate() {
		// calculate with formula
		// this.accumulationRate =
	}

	public void updateScoreEcono() {
		// calculate with formula
		// this.ScoreEcono =
	}

}