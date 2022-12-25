import java.util.ArrayList;
import java.io.Serializable;

public class AccountController implements Serializable {
	
	private ArrayList<Resident> residents = new ArrayList<Resident>();
	private ArrayList<Consumer> consumers = new ArrayList<Consumer>();

	public void addResident(Resident resident) {
		residents.add(resident);
	}

	public void addConsumer(Consumer consumer) {
		consumers.add(consumer);
	}

	public ArrayList<Resident> getResidents() { return residents;}
	public ArrayList<Consumer> getConsumers() { return consumers; }




}