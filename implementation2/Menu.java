// Todo:
// metrics functionality
// municipal process status functionality, lot de dechets (waste from many residents) //see DM2, DM3 site
// seperate menu, residentmenu, consumermenu code, main function?
// use enum for bin type
//? quit action if "quit" entered
// empty user inputs invalid
// bin registration: check qr code is a existing code in municip
// consumer account creation: check consumer code is a existing code in municip
// bin list view basic info -> selected bin detail view
// proper account,menu,etc abstraction/inheritance/polymorphism; peoper architecture MVC; repitition avoid
// data persistence (saving/loading data): write/read csv. objects. // update CSV after every  action that modify/create/delete object

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	//todo: load all data //? or load/access csv when needed. //assign csv files names //? in menu or in controllers class
	
	Scanner scanner = new Scanner(System.in);

	AccountController accountController = new AccountController(); // make functions to load/save from csv
	BinController binController = new BinController();
	ArrayList<String> notifications = new ArrayList<String>();

	Account loggedUser; // resident/consumer loggedUser // boolean residentconnected/cocnsumer

	boolean exit; // false by default // used for exiting the app (breaking out of the while loop)

	public static void main(String[] args) { // main method in Menu, because Menu will be where the program execute from. // Possibly can make another file that just has this main method.
		Menu menu =  new Menu();
		menu.runMenu();
	}

	public void runMenu() { // prints the header, then it starts a while loop. // basically whole program // menu is the authentication page
		//printHeader();
		while(!exit) { // && loggedUser == null
			System.out.println("\n+===========================+"); // print header
			System.out.println("     Welcome to BINECO!    ");
			System.out.println("+===========================+");
			System.out.println("Please select an option: "); 
			System.out.println("[1] Login");
			System.out.println("[2] Create a new Resident account");
			System.out.println("[3] Create a new Consumer account");
			System.out.println("[0] Exit application ");
			int choice = getChoice(3);
			performAuthPageAction(choice); // after each action is completed, we are returned to the Menu // Possibly: if we wanted another kind of menu, it would have its own while(!exit), and when that one exits, we return back to main menu (runMenu()) 's loop
			/* if loggedUser != null and loggedUser instanceOf Resident
				runResidentMenu() */

			// if logged in
			if (loggedUser != null) {
				if (loggedUser instanceof Resident) {
					runResidentMenu();
				}
				else if (loggedUser instanceof Consumer) {
					runConsumerMenu();
				}
			}
		}
	}

	// reusable function to get a valid choice from multiple numbered choice menu // only for consecutive int choices [1 to n]
	private int getChoice(int numOfChoices) { // number of choices that are not 0 (this function still accepts 0)
		int choice = -1;
		do {
			System.out.print("Enter your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input. Numbers only.");
			}
			if (choice < 0 || choice > numOfChoices) {
				System.out.println("Choice outside of range. Please choose again.");
			}
		} while (choice < 0 || choice > numOfChoices);
		return choice;	
	}

	private void performAuthPageAction(int choice) {
		switch(choice) {
			case 0: {
				System.out.println("Application closed.");
				System.exit(0);
				break; 
			}

		 	case 1: { // Login
		 		login();
		 		break;
		 	}

		 	case 2: { // create an account
		 		createResidentAccount();
		 		break;
		 	}

		 	case 3: {
		 		createConsumerAccount();
		 		break;
		 	}

		 	default: {
		 		System.out.println("An unknown error has occured.");
		 	}
		}
	}


	private void login() {
		System.out.println("\n=== LOGIN ===");

		boolean valid = false, exit = false;
		while(valid == false && exit == false) {
			System.out.print("E-mail address: ");
			String email = scanner.nextLine();
			System.out.print("Password: ");
			String password = scanner.nextLine();
			for (Resident resident : accountController.getResidents()) {
				if (email.equalsIgnoreCase(resident.getEmail()) && password.equals(resident.getPassword())) {
					valid = true;
					loggedUser = resident;
					System.out.println(((Resident)loggedUser).getFirstName() + ", you have successfully logged in!");
					break;
				}
			}
			for (Consumer consumer : accountController.getConsumers()) {
				if (email.equalsIgnoreCase(consumer.getEmail()) && password.equals(consumer.getPassword())) {
					valid = true;
					loggedUser = consumer;
					System.out.println(((Consumer)loggedUser).getName() + ", you have successfully logged in!");
					break;
				}
			}
			if (valid) {
				break;
			} else {
				System.out.println("E-mail or password is wrong. Or account may not exist.");
				exit = true;
			}
		}
	}

	private void createResidentAccount() {
		String lastName, firstName, email = "", telephone, address, password; // values that we will use as input to ?controllers/models
		Bin initialBin;

		System.out.println("\n=== RESIDENT ACCOUNT CREATION ===");
		System.out.print("Last name: ");
		lastName = scanner.nextLine();
		System.out.print("First name: ");
		firstName = scanner.nextLine();

		boolean invalidEmail = false; // email availability check
		do {
			System.out.print("E-mail address: ");
			email = scanner.nextLine();

			boolean resEmailExists = false;
			for (Resident resident : accountController.getResidents()) {
				if (email.equalsIgnoreCase(resident.getEmail())) {
					resEmailExists = true;
					System.out.println("E-mail already in use.");
					break;
				}
			}

			boolean conEmailExists = false;

			for (Consumer consumer : accountController.getConsumers()) {
				if (email.equalsIgnoreCase(consumer.getEmail())) {
					resEmailExists = true;
					System.out.println("E-mail already in use.");
					break;
				}
			}

			if (resEmailExists || conEmailExists) {
				invalidEmail = true;
			} else {
				invalidEmail = false;
			}

		} while (invalidEmail == true);


		System.out.print("Residence telephone number: ");
		telephone = scanner.nextLine();
		System.out.print("Residential address: ");
		address = scanner.nextLine();
		System.out.print("Create a password: ");
		password = scanner.nextLine();

		System.out.println("\n=== BIN REGISTRATION ===");
		System.out.print("QR code: ");
		String qrCode = scanner.nextLine();
		System.out.print("Bin name: ");
		String binName = scanner.nextLine();
		System.out.print("Bin type ([1] COMPOST / [2] RECYCLE / [3] TRASH): ");
		String binType = scanner.nextLine();
		while (!binType.equalsIgnoreCase("1") && !binType.equalsIgnoreCase("2") && !binType.equalsIgnoreCase("3")) {
			System.out.println("Enter a valid bin type ([1] COMPOST / [2] RECYCLE / [3] TRASH): ");
			binType = scanner.nextLine();
		}
		if (binType.equalsIgnoreCase("1")) {
			binType = "COMPOST";
		} else if (binType.equalsIgnoreCase("2")) {
			binType = "RECYCLE";
		} else if (binType.equalsIgnoreCase("3")) {
			binType = "TRASH";
		}

		initialBin = new Bin(qrCode, binName, binType, address);
		Resident resident = new Resident(lastName, firstName, email, telephone, address, password, initialBin);
		accountController.addResident(resident);
		binController.addBin(initialBin);

		System.out.println("An account confirmation link has been sent to your e-mail address. Please confirm your account within 3 days.");
	}

	private void createConsumerAccount() {
		String code, name, address, email, telephone, wasteTypes, password;
		ArrayList<ConsumerActivity> activities = new ArrayList<ConsumerActivity>();
		double processingCapacity = -1;

		System.out.println("\n=== CONSUMER ACCOUNT CREATION ===");
		System.out.print("Code: ");
		code = scanner.nextLine(); // TODO: verification-must match an existing code found in municipal's database
		System.out.print("Name: ");
		name = scanner.nextLine();
		System.out.print("Address: ");
		address = scanner.nextLine();
		
		boolean invalidEmail = false; // email availability check
		do {
			System.out.print("E-mail address: ");
			email = scanner.nextLine();

			boolean resEmailExists = false;
			for (Resident resident : accountController.getResidents()) {
				if (email.equalsIgnoreCase(resident.getEmail())) {
					resEmailExists = true;
					System.out.println("E-mail already in use.");
					break;
				}
			}

			boolean conEmailExists = false;
			for (Consumer consumer : accountController.getConsumers()) {
				if (email.equalsIgnoreCase(consumer.getEmail())) {
					resEmailExists = true;
					System.out.println("E-mail already in use.");
					break;
				}
			}

			if (resEmailExists || conEmailExists) {
				invalidEmail = true;
			} else {
				invalidEmail = false;
			}

		} while (invalidEmail == true);

		System.out.print("Telephone: ");
		telephone = scanner.nextLine();
		System.out.print("Processed types of waste: ");
		wasteTypes = scanner.nextLine();

		System.out.println("\nActivities: "); //? activities should be a list in consumers. Loop input->addActivity, until 0 is input
		String activityName = "";
		while (activities.size() < 1 || !activityName.equalsIgnoreCase("0")) {
			System.out.print("Enter an activity or enter 0 to continue to the next step: ");
			activityName = scanner.nextLine();

			if (!activityName.equalsIgnoreCase("0")) {
				activities.add(new ConsumerActivity(activityName));
			}

			if (activityName.equalsIgnoreCase("0")) {
				System.out.print("The activities have been added to your profile: ");
				for (ConsumerActivity activity : activities) {
					System.out.print(activity.getName());
					if (!(activity == activities.get(activities.size()-1))) {
						System.out.print(", ");
					} else {
						System.out.println("");
					}
				}
			}
		}
		
		while (processingCapacity <= 0) {
			try {
				System.out.print("\nProcessing capacity (kg): ");
				processingCapacity = Double.parseDouble(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input. Must be a number.");
			}
			if (processingCapacity <= 0) {
				System.out.println("Processing capacity cannot be 0 or less!");
			}
		}
		System.out.print("Create a password: ");
		password = scanner.nextLine();

		Consumer consumer = new Consumer(code, name, address, email, telephone, wasteTypes, activities, processingCapacity, password);
		accountController.addConsumer(consumer);

		System.out.println("An account confirmation link has been sent to your e-mail address. Please confirm your account within 3 days.");

	}

//////////////////////////////////////////RESIDENT////////////////////////////////////////////////////////////
	private void runResidentMenu() {
		boolean logout = false;
		while(logout == false) {
			// display first 5 notifications //? add menu option to show all notifications
			System.out.println("\n=== NOTIFICATIONS (new to old) ===");

			if (notifications.size() >= 5) {
				for (int i=0; i < 5; i++) {
					System.out.println(notifications.get(i));
				}
			} else {
				for (String notification : notifications) {
					System.out.println(notification);
				}
			}

			System.out.println("\n+===========================+");
			System.out.println("     RESIDENT MENU    ");
			System.out.println("+===========================+");
			System.out.println("Welcome " + ((Resident) loggedUser).getFirstName() + "! Please select an option: ");
			System.out.println("[1] Register a bin");
			System.out.println("[2] Remove a bin");
			System.out.println("[3] Display your bins");
			System.out.println("[4] View ecological metrics");
			System.out.println("[5] Municipal waste process");
			System.out.println("[6] Report a problem");
			System.out.println("");
			System.out.println("[7] Find a consumer and rate activities");
			System.out.println("");
			System.out.println("[8] Modify your profile");
			System.out.println("[0] Log out ");

			int choice = getChoice(9); // has the print "Enter your choice"
			if (choice == 0) {
				loggedUser = null;
				return;
			}
			performResidentAction(choice);
		}
	}

	private void performResidentAction(int choice) {
		switch(choice) {

		 	case 1: { // register a bin
		 		String qrCode, binName, binType;

				boolean invalidQRCode = false; // qrCode availability check
				do {
					System.out.print("QR Code: ");
					qrCode = scanner.nextLine();

					boolean qrCodeExists = false;
					for (Bin bin : binController.getBins()) {
						if (qrCode.equalsIgnoreCase(bin.getQRCode())) {
							qrCodeExists = true;
							System.out.println("QR code already registered!");
							break;
						}
					}

					if (qrCodeExists == true) {
						invalidQRCode = true;
					} else {
						invalidQRCode = false;
					}

				} while (invalidQRCode == true);

				System.out.print("Bin name: ");
				binName = scanner.nextLine();

				System.out.print("Bin type ([1] COMPOST / [2] RECYCLE / [3] TRASH): ");
				binType = scanner.nextLine();
				while (!binType.equalsIgnoreCase("1") && !binType.equalsIgnoreCase("2") && !binType.equalsIgnoreCase("3")) {
					System.out.println("Enter a valid bin type ([1] COMPOST / [2] RECYCLE / [3] TRASH): ");
					binType = scanner.nextLine();
				}
				if (binType.equalsIgnoreCase("1")) {
					binType = "COMPOST";
				} else if (binType.equalsIgnoreCase("2")) {
					binType = "RECYCLE";
				} else if (binType.equalsIgnoreCase("3")) {
					binType = "TRASH";
				}

				Bin newBin = new Bin(qrCode, binName, binType, ((Resident) loggedUser).getAddress());
				((Resident) loggedUser).addBin(newBin);
				binController.addBin(newBin);

				System.out.println("Bin successfully added!");

		 		break;
		 	}

		 	case 2: { // unregister a bin // inspiration: bankapp listbalances
		 		ArrayList<Bin> myBins = ((Resident) loggedUser).getRegisteredBins();

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

		 		break;
		 	}

		 	case 3: { // show bins states // should list bins basic info, then able to select bin to show details of bin
		 		System.out.println("\n=== YOUR BINS ===");
		 		// for (Bin bin : ((Resident) loggedUser).getRegisteredBins()) {
		 		// 	System.out.println("Bin QR Code: " + bin.getQRCode() + " | " + "Bin name: " + bin.getName() + " | " + "Bin type: " + bin.getType());
		 		// }
		 		ArrayList<Bin> residentsBins = ((Resident) loggedUser).getRegisteredBins();
		 		for (int i=0; i < residentsBins.size(); i++) {
		 			Bin bin = residentsBins.get(i);
		 			System.out.println("(Bin " + (i+1) + ") " + "Bin QR Code: " + bin.getQRCode() + " | " + "Bin name: " + bin.getName() + " | " + "Bin type: " + bin.getType());
		 			System.out.println("Current fill level: " + bin.getFilledLevel() + " | Composition: " + bin.getComposition() + "\n");
		 		}
		 		break;
		 	}

		 	case 4: { // View ecological metrics
		 		break;
		 	}

		 	case 5: { // View processing state of city's waste / lots //? something to do with binController? //? get info from municipinfo
		 		break;
		 	}

		 	case 6: { // report a problem to city
		 		System.out.println("\n=== REPORT A PROBLEM ===");
		 		System.out.print("Type of problem: ");
		 		String problem = scanner.nextLine();

		 		System.out.println("Thank you for reporting your problem.");
		 		break;
		 	}

		 	case 7: { // Find a consumer // search functionality : by name or by activities //? should be find a consumer and rate an activity
		 		ArrayList<Consumer> searchResults = accountController.getConsumers(); // all consumers
		 		int consumerChoice = -1;
		 		// boolean exitConsumerSearch;
		 		System.out.println("\n=== FIND A CONSUMER ===");
		 		while (consumerChoice != 0) {
		 			//ArrayList<Consumer> searchResults = accountController.getConsumers();
			 		System.out.println("=== Search results ===");

			 		if (searchResults.size() < 1) {
			 			System.out.println("There are no consumers right now. Please try again later.");
			 			break;
			 		}

			 		// list choices
					for (int i=0; i < searchResults.size(); i++) {
						System.out.println("[" + (i+1) + "] " + searchResults.get(i).getName());
					}
					System.out.println("\n[" + (searchResults.size()+1) + "] Keyword Search (One word, singular)");
					System.out.println("\n[0] Go Back");



					// choose and show details of selection
					consumerChoice = getChoice(searchResults.size() + 1);
					if (consumerChoice == 0) { break; }
					 					
 					Consumer chosenConsumer;
					if (consumerChoice != 0 || consumerChoice != searchResults.size()+1) {
						chosenConsumer = searchResults.get(consumerChoice-1);

						System.out.println(chosenConsumer.getName() + " | " + chosenConsumer.getWasteTypes()); // + activities + activity avg rating

						System.out.println("[1] Rate an activity");
						System.out.println("[0] Go back");

						consumerChoice = getChoice(1);

						switch(consumerChoice) {
							case 1: { // RATE : list activities and rate
								ArrayList<ConsumerActivity> chosenConsumerActivities = chosenConsumer.getActivities();
								// list activities
								for (int i=0; i < chosenConsumerActivities.size(); i++) {
									System.out.println("[" + (i+1) + "] " + chosenConsumerActivities.get(i).getName());
								}

								int activityChoice = -1;
								activityChoice = getChoice(chosenConsumerActivities.size());
								ConsumerActivity chosenActivity = chosenConsumerActivities.get(activityChoice-1);
								// todo: implement input verification
								double rating = -1;
								System.out.print("Enter a rating out of 5");
								rating = Double.parseDouble(scanner.nextLine());
								chosenActivity.addRating(rating);

								chosenConsumer.updateRating();

								break;
							}

							case 0: {
								consumerChoice = -1;
								continue;
							} 
						} 

						continue;

					}

					if (consumerChoice == 0) break;

					if (consumerChoice == (searchResults.size()+1)) { // search
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
					}

		 		}

		 		break;
		 	}

		 	case 8: {
		 		System.out.println("\n=== MODIFY YOUR PROFILE ===");
		 		int modifyChoice = -1;
		 		// display current information

		 		while (modifyChoice != 0) {
		 			System.out.println("[1] Change name"); 
		 			System.out.println("[2] Change email"); 
		 			System.out.println("[3] Change telephone number");
		 			System.out.println("[4] Change address");
		 			System.out.println("[5] Change password");
		 			System.out.println("[0] Back to menu");

		 			modifyChoice = getChoice(5);

		 			switch(modifyChoice) {
		 				case 1: {
		 					System.out.print("Change first name to: ");
		 					String firstName = scanner.nextLine();
		 					System.out.print("Change last name to: ");
		 					String lastName = scanner.nextLine();

		 					((Resident) loggedUser).setLastName(lastName);
		 					((Resident) loggedUser).setFirstName(firstName);
		 					break;

		 				}
		 				case 2: {
		 					System.out.print("Change email to: ");
		 					String email = scanner.nextLine();
		 					((Resident) loggedUser).setLastName(email);
		 					break;

		 				}
		 				case 3: {
		 					System.out.print("Change telephone number: ");
		 					String telephone = scanner.nextLine();
		 					((Resident) loggedUser).setTelephone(telephone);
		 					break;

		 				}
		 				case 4: {
		 					System.out.print("Change address to: ");
		 					String address = scanner.nextLine();
		 					((Resident) loggedUser).setAddress(address);
		 					break;
		 				}
		 				case 5: {
		 					System.out.print("Change password to: ");
		 					String password = scanner.nextLine();
		 					((Resident) loggedUser).setPassword(password);
		 					break;

		 				}
		 				case 0: {
		 					break;
		 				}

		 				default: {
		 					System.out.println("Unknown error occured.");
		 					modifyChoice = 0;
		 					break;
		 				}

		 			}
		 		}
		 	}

		 	default: {
		 		System.out.println("An unknown error has occured.");
		 	}

		}
	}


//////////////////////////////////////////CONSUMER///////////////////////////////////////////////////
	private void runConsumerMenu() {
		boolean logout = false;
		while(logout == false) {
			System.out.println("\n+===========================+");
			System.out.println("     CONSUMER MENU    ");
			System.out.println("+===========================+");
			System.out.println("Welcome " + ((Consumer) loggedUser).getName() + "! Please select an option: ");
			System.out.println("[1] Add an activity"); // TODO: resident should be notified of all activity changes
			System.out.println("[2] Modify an activity"); 
			System.out.println("[3] Delete an activity"); 
			System.out.println("[4] Notify residents of a need\n"); 
			System.out.println("[5] Modify your profile");
			System.out.println("[0] Log out ");
			
			int choice = getChoice(5);
			if (choice == 0) {
				loggedUser = null;
				return;
			}
			performConsumerAction(choice);
		}
	}

	private void performConsumerAction(int choice) {
		ArrayList<ConsumerActivity> myActivities = null;
		if (loggedUser != null) {
			myActivities = ((Consumer) loggedUser).getActivities();
		}

		switch(choice) {
			case 1: { // add an activities
				String notification = "New activities from " + ((Consumer) loggedUser).getName() + ": ";

				System.out.println("=== ADD AN ACTIVITY ===");
				String activityName = "";
				while (!activityName.equalsIgnoreCase("0")) {
					System.out.print("Enter an activity or enter 0 to continue to the next step: ");
					activityName = scanner.nextLine();

					if (!activityName.equalsIgnoreCase("0")) {
						((Consumer) loggedUser).addActivity(new ConsumerActivity(activityName));
						notification += activityName + ", ";
					}

					else if (activityName.equalsIgnoreCase("0")) {
						System.out.print("Your updated list of activities: ");
						for (ConsumerActivity activity : myActivities) {
							System.out.print(activity.getName());
							if (!(activity == myActivities.get(myActivities.size()-1))) {
								System.out.print(", ");
							} else {
								System.out.println("");
							}
						}
					}
				}
				notifications.add(0, notification.substring(0, notification.length() - 2));
				break;
			}

			case 2: { // modify one activity
				System.out.println("=== MODIFY AN ACTIVITY ===");

				for (int i=0; i < myActivities.size(); i++) {
					System.out.println("[" + (i+1) + "] " + myActivities.get(i).getName());
				}
				System.out.println("\n[0] CANCEL");

				int activityChoice = getChoice(myActivities.size());
				String oldName = myActivities.get(activityChoice-1).getName();
				System.out.print("Rename activity to: ");
				String newName = scanner.nextLine();
				myActivities.get(activityChoice-1).setName(newName);


				System.out.print("Your updated activities list: ");
				for (ConsumerActivity activity : myActivities) {
					System.out.print(activity.getName());
					if (!(activity == myActivities.get(myActivities.size()-1))) {
						System.out.print(", ");
					} else {
						System.out.println("");
					}
				}

				notifications.add(0, ((Consumer) loggedUser).getName() + " renamed activity " + oldName + " to " + newName + ".");
				break;
			}
			

			case 3: { // remove one activity
				System.out.println("=== REMOVE AN ACTIVITY ===");

				for (int i=0; i < myActivities.size(); i++) {
					System.out.println("[" + (i+1) + "] " + myActivities.get(i).getName());
				}
				System.out.println("\n[0] CANCEL");

				int activityChoice = getChoice(myActivities.size());
				if (activityChoice == 0) { break; }

				String activityName = myActivities.get(activityChoice-1).getName();
				myActivities.remove(activityChoice-1);

				System.out.print("Your updated activities list: ");
				for (ConsumerActivity activity : myActivities) {
					System.out.print(activity.getName());
					if (!(activity == myActivities.get(myActivities.size()-1))) {
						System.out.print(", ");
					} else {
						System.out.println("");
					}
				}
				notifications.add(0, ((Consumer) loggedUser).getName() + " removed activity " + activityName + ".");
				break;

			}

			case 4: { // notify residents of a need
				System.out.println("\n=== NOTIFY RESIDENTS OF A NEED ===");
				int notifChoice = -1;
				System.out.println("Notification type: [1] Awareness | [2] Accumulation // [0] Cancel");
				notifChoice = getChoice(2);
				if (notifChoice == 0) {
					break;
				}

				switch(notifChoice) {
					case 1: {
						System.out.print("Enter waste types to be aware of: ");
						String notification = ((Consumer) loggedUser).getName() + ": \"Please be aware of: " + scanner.nextLine() + "\"";
						notifications.add(0, notification);
					}

					case 2: {
						System.out.print("Enter waste types to accumulate: ");
						String notification = ((Consumer) loggedUser).getName() + ": \"Please accumulate: " + scanner.nextLine() + "\"";
						notifications.add(0, notification);
					}
				} 

				break;
			}

			case 5: { // modify profile
				System.out.println("\n=== MODIFY YOUR PROFILE ===");
		 		int modifyChoice = -1;

		 		// display current information

		 		while (modifyChoice != 0) {
		 			System.out.println("[1] Change name"); 
		 			System.out.println("[2] Change address"); 
		 			System.out.println("[3] Change email");
		 			System.out.println("[4] Change waste types: ");
		 			System.out.println("[5] Change processing capacity: ");
		 			System.out.println("[6] Change password");
		 			System.out.println("[0] Back to menu");

		 			modifyChoice = getChoice(5);

		 			switch(modifyChoice) {
		 				case 1: {
		 					System.out.print("Change name to: ");
		 					String name = scanner.nextLine();

		 					((Consumer) loggedUser).setName(name);
		 					break;

		 				}
		 				case 2: {
		 					System.out.print("Change address to: ");
		 					String address = scanner.nextLine();
		 					((Consumer) loggedUser).setAddress(address);
		 					break;

		 				}
		 				case 3: {
		 					System.out.print("Change email: ");
		 					String email = scanner.nextLine();
		 					((Consumer) loggedUser).setEmail(email);
		 					break;

		 				}
		 				case 4: {
		 					System.out.print("Change waste types: ");
		 					String wasteTypes = scanner.nextLine();
		 					((Consumer) loggedUser).setWasteTypes(wasteTypes);
		 					break;
		 				}
		 				case 5: {
		 					System.out.print("Change processing capacity to: ");
		 					double processingCapacity = Double.parseDouble(scanner.nextLine());
		 					((Consumer) loggedUser).setProcessingCapacity(processingCapacity);
		 					break;

		 				}

		 				case 6: {
		 					System.out.println("Change password to: ");
		 					String password = scanner.nextLine();
		 					((Consumer) loggedUser).setPassword(password);
		 				}
		 				case 0: {
		 					break;
		 				}

		 				default: {
		 					System.out.println("Unknown error occured.");
		 					modifyChoice = 0;
		 					break;
		 				}
		 			}
		 		}
				break; // break out of while loop after action successful

			} // modify profile switch bracket

		} // consumer action switch bracket

	} // method bracket



} // class bracket