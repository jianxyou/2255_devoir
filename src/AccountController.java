import java.util.ArrayList;
import java.io.Serializable;
/**
 * AccountController implemennte Serializable creer deux liste de resident et consumer
 * @author admin
 *
 */
public class AccountController implements Serializable {
	
	private ArrayList<Resident> residents = new ArrayList<Resident>();
	private ArrayList<Consumer> consumers = new ArrayList<Consumer>();
	/**
	 * addResident: ajoute une instance resident au liste de resident 
	 * @param resident instante de la classe resident
	 */
	public void addResident(Resident resident) {
		residents.add(resident);
	}
	/**
	 * addConsumer: ajoute une instance consumer au liste de consumer
	 * @param consumer instance de consumer
	 */
	public void addConsumer(Consumer consumer) {
		consumers.add(consumer);
	}
	/**
	 * 
	 * @return la liste de resident
	 */
	public ArrayList<Resident> getResidents() { return residents;}
	/**
	 * 
	 * @return la liste de consumer
	 */
	public ArrayList<Consumer> getConsumers() { return consumers; }




}