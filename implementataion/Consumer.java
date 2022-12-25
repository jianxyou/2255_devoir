import java.util.ArrayList;
import java.io.Serializable;

public class Consumer extends Account implements Serializable {
	
	private String code, name, address, email, telephone, wasteTypes, password;
	private double processingCapacity;
	private ArrayList<ConsumerActivity> activities; 
	private double rating; // is equal to the average rating of all the consumer's activities' average ratings

	public Consumer() {} //test purposes
	public Consumer(String name, String email, String wasteTypes, ArrayList<ConsumerActivity> activities) { // testing purposes constructor
		this.name = name;
		this.email = email;
		this.wasteTypes = wasteTypes;
		this.activities = activities;
	}
	
	public Consumer(String code, String name, String address, String email, String telephone, String wasteTypes, ArrayList<ConsumerActivity> activities, double processingCapacity, String password) {
		this.code = code;
		this.name = name;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.wasteTypes = wasteTypes;
		this.activities = activities;
		this.processingCapacity = processingCapacity;
		this.password = password;
	}

	public String getCode(){ return code;}
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public ArrayList<ConsumerActivity> getActivities() { return activities; }
	public String getWasteTypes() { return wasteTypes; }

	public void setName(String name) { this.name = name; }
	public void setAddress(String address) { this.address = address; }
	public void setEmail(String email) { this.email = email; }
	public void setTelephone(String telephone) { this.telephone = telephone; }
	public void setWasteTypes(String wasteTypes) { this.wasteTypes = wasteTypes; }
	public void setPassword(String password) { this.password = password; }
	public void setProcessingCapacity(double processingCapacity) { this.processingCapacity = processingCapacity; }


	public void addActivity(ConsumerActivity activity) {
		activities.add(activity);
	}

	public void updateRating() { // rating of Consumer = average of avg rating of each of activites //? add Consumer owner attribute to consumeractivity so activity can call this when activity gets a new rating
		double sum = 0;
		double avg;
		for (ConsumerActivity activity : activities) {
			sum += activity.getAverageRating();
		}
		avg = sum / activities.size();

		this.rating = avg;
	}

}