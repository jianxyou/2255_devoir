import java.util.ArrayList;
import java.util.Scanner;

public class UnitTests2 {

	public static void main(String[] args) {
	/* 
	jianxin: metrique, login (account, password), consumer rating
	-verify qr code / bin register
	-verify consumer code / cons register
	-bin unregister
	-consumer search
	-consumer activity rating
	-consumer rating
	-delete activity
	-modify activity
	*/

		// run tests : java -ea UnitTests2

	/////////////// consumerSearch() Test setup
	String con1wasteTypes = "recycle, paper, glass";
	ArrayList<ConsumerActivity> con1activities = new ArrayList<>();
	con1activities.add(new ConsumerActivity("fabrication of cardboard boxes"));
	con1activities.add(new ConsumerActivity("fabrication of glass bottles"));
	Consumer consumer1 = new Consumer("RecycleCompany", "recyclecompany@mail.com", con1wasteTypes, con1activities);

	String con2wasteTypes = "recycle, paper, plastic";
	ArrayList<ConsumerActivity> con2activities = new ArrayList<>();
	con2activities.add(new ConsumerActivity("fabrication of plastic boxes"));
	con2activities.add(new ConsumerActivity("fabrication of plastic bottles"));
	con2activities.add(new ConsumerActivity("fabrication of cartons"));
	Consumer consumer2 = new Consumer("the reusable makers", "reusablemakers@mail.com", con2wasteTypes, con2activities);

	String con3wasteTypes = "compost, food waste, plants";
	ArrayList<ConsumerActivity> con3activities = new ArrayList<>();
	con3activities.add(new ConsumerActivity("fabrication of soil"));
	con3activities.add(new ConsumerActivity("farming organic vegetables"));
	Consumer consumer3 = new Consumer("compost company", "compostcompany@mail.com", con3wasteTypes, con3activities);

	ArrayList<Consumer> allConsumers = new ArrayList<>();
	allConsumers.add(consumer1);
	allConsumers.add(consumer2);
	allConsumers.add(consumer3);

		// Test 1: search term found in multiple consumers
	ArrayList<Consumer> search1 = consumerSearch(allConsumers, "paper");
	assert (search1.contains(consumer1) && search1.contains(consumer2) && search1.size() == 2);
		// Test 2: search term found in 1 consumer
	ArrayList<Consumer> search2 = consumerSearch(allConsumers, "plastic");
	assert (search2.contains(consumer2) && search2.size() == 1);
		// Test 3: search by name
	ArrayList<Consumer> search3 = consumerSearch(allConsumers, "company");
	assert (search3.contains(consumer1) && search3.contains(consumer3) && search3.size() == 2);
		// Test 4: search term missing ending letters
	ArrayList<Consumer> search4 = consumerSearch(allConsumers, "glas");
	assert (search4.contains(consumer1) && search4.size() == 1);
		// Test 5: search term typo
	ArrayList<Consumer> search5 = consumerSearch(allConsumers, "glasd");
	assert (search5.size() == 0);
		// Test 6: search empty string
	ArrayList<Consumer> search6 = consumerSearch(allConsumers, "");
	assert (search6.size() == 3);


	/////////////// unregisterBin() test setup
	Bin testBin1 = new Bin();
	Bin testBin2 = new Bin();
	Bin testBin3 = new Bin();
	ArrayList<Bin> resident1bins;

		// Test 1: resident entered 0
	resident1bins = new ArrayList<Bin>();
	resident1bins.add(testBin1);
	resident1bins.add(testBin2);
	resident1bins.add(testBin3);

	unregisterBin(resident1bins, 0);
	assert (resident1bins.contains(testBin1) && resident1bins.contains(testBin2) && resident1bins.contains(testBin3));

		// Test 2: resident entered negative
	resident1bins = new ArrayList<Bin>();
	resident1bins.add(testBin1);
	resident1bins.add(testBin2);
	resident1bins.add(testBin3);

	unregisterBin(resident1bins, -1);
	assert (resident1bins.contains(testBin1) && resident1bins.contains(testBin2) && resident1bins.contains(testBin3));


		// Test 3: resident entered one of the displayed choices
	resident1bins = new ArrayList<Bin>();
	resident1bins.add(testBin1);
	resident1bins.add(testBin2);
	resident1bins.add(testBin3);

	unregisterBin(resident1bins, 2);
	assert (resident1bins.contains(testBin1) && resident1bins.contains(testBin3) && resident1bins.size() == 2);

		// Test 4: resident entered a choice number higher than last displayed choice
	resident1bins = new ArrayList<Bin>();
	resident1bins.add(testBin1);
	resident1bins.add(testBin2);
	resident1bins.add(testBin3);

	unregisterBin(resident1bins, 4);
	assert (resident1bins.contains(testBin1) && resident1bins.contains(testBin2) && resident1bins.contains(testBin3));

	}


	

	// searchTerm must be one keyword, in preferabky singular / beginning of word which is the same in singular/plural form
	// search by name or waste type or activity
	public static ArrayList<Consumer> consumerSearch(ArrayList<Consumer> allConsumers, String searchTerm) {
		ArrayList<Consumer> searchResults = new ArrayList<>();
		String searchTermLC = searchTerm.toLowerCase();

		if (allConsumers.size() < 1) {
			return new ArrayList<Consumer>();
		}

		for (Consumer consumer : allConsumers) {
			if (consumer.getWasteTypes().toLowerCase().contains(searchTermLC) || consumer.getName().toLowerCase().contains(searchTermLC)) {
				searchResults.add(consumer);
			}

			else {
				for (ConsumerActivity activity : consumer.getActivities()) {
					if (activity.getName().toLowerCase().contains(searchTermLC)) {
						searchResults.add(consumer);
					}
				}
			}
		}
		return searchResults;
	}

	// index of bin to remove is (choice - 1)
	public static void unregisterBin(ArrayList<Bin> registeredBins, int userChoice) {
		if (userChoice == 0 || userChoice < 0 || userChoice > registeredBins.size()) { return; } 

		int chosenBinIndex = userChoice - 1;
		Bin chosenBin = registeredBins.get(chosenBinIndex);
		registeredBins.remove(chosenBin);
	}

	// a validCode is a qr code existing in MunicipInfo's list of bin codes. // check if qrcode can be used for signup
	// public static boolean validateQRCode(ArrayList<Bin> existingBins, String qrCode) {
	// 	for (Bin existingBin : existingBins) {
	// 		if (qrCode.equals(existingBin.getQRCode()) && )
	// 	}
	// }

}

/*

case 2: { // unregister a bin
		 		System.out.println("=== REMOVE A BIN ===");

				for (int i=0; i < myBins.size(); i++) {
					System.out.println("[" + (i+1) + "] " + myBins.get(i).getName());
				}
				System.out.println("\n[0] CANCEL");

				int binChoice = getChoice(myBins.size());
				if (binChoice == 0) { break; }

				String binName = myBins.get(binChoice-1).getName();
				myBins.remove(binChoice-1);
				binController.removeBin(myBins.get(binChoice-1));

				System.out.println("Bin " + binName + " has been removed.");
				System.out.print("Your updated bins list: ");
				for (Bin bin : myBins) {
					System.out.print(bin.getName());
					if (!(bin == myBins.get(myBins.size()-1))) {
						System.out.print(", ");
					} else {
						System.out.println("");
					}
				}

				serializeChanges();
		 		break;
		 	}


*/





/*

					if (consumerChoice == (searchResults.size()+1)) { // search functionality
						String searchTerm = scanner.nextLine();
						searchResults = new ArrayList<Consumer>();

						for (Consumer consumer : accountController.getConsumers()) {
							if (consumer.getWasteTypes().contains(searchTerm) || consumer.getName().contains(searchTerm)) {
								searchResults.add(consumer);
							}

							else {
								for (ConsumerActivity activity : consumer.getActivities()) {
									if (activity.getName().contains(searchTerm)) {
										searchResults.add(consumer);
									}
								}
							}

						}

						if (searchResults.size() < 1) {
							System.out.println("No results found. Will now show default list.");
							searchResults = accountController.getConsumers();
						} else {
							for (int i=0; i < searchResults.size(); i++) {
							System.out.println("[" + (i+1) + "] " + searchResults.get(i).getName());
							}
						}


*/
