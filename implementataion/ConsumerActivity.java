import java.util.ArrayList;
import java.io.Serializable;

public class ConsumerActivity implements Serializable {

	private String name; //? String description
	private ArrayList<Double> ratings = new ArrayList<Double>();
	private double averageRating;

	public ConsumerActivity(String name) {
		this.name = name;
	}

	public String getName() { return name; }
	//public ArrayList<Double> getRatings() { return ratings; }
	public double getAverageRating() { return averageRating; }


	public void setName(String name) { this.name = name; }

	public void addRating(double rating) {
		ratings.add(rating);
		updateAverageRating(); // of the activity
	}

	private void updateAverageRating() {
		double sum = 0;
		double average;
		for (double rating : ratings) {
			sum += rating;
		}
		average = sum / ratings.size();

		this.averageRating = average;

	}
}