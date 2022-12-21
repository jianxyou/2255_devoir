import java.util.ArrayList;

public class Resident extends Account {

	private String lastName, firstName, email, telephone, address, password;
	// compteconfirme en 3 jours? boolean
	private ArrayList<Bin> registeredBins = new ArrayList<Bin>();

	public Resident(String lastName, String firstName, String email, String telephone, String address, String password, Bin initialBin) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.password = password;
		this.registeredBins.add(initialBin);
	}

	public void addBin(Bin bin) {
		registeredBins.add(bin);
	}

	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setEmail(String email) { this.email = email; }
	public void setTelephone(String telephone) { this.telephone = telephone; }
	public void setAddress(String address) { this.address = address; }
	public void setPassword(String password) { this.password = password; }



	public ArrayList<Bin> getRegisteredBins() { return registeredBins; }
	public String getEmail() { return email; }
	public String getAddress() { return address; }
	public String getPassword() { return password; }
	public String getFirstName() { return firstName; }

}