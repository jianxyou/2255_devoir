import java.io.*;
//import java.io.File;

/**
 * Cette classe contient la main methode pour rouler l'application. Et la logique permettant la persistence des donnees.
*/
public class App {

	private static Menu menu;

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

		// Load save file if it exists
		File menuSer = new File("Menu.ser");
		if (menuSer.exists() && !menuSer.isDirectory()) {
			System.out.println(menuSer + " exists.");

			FileInputStream fileIn = new FileInputStream("Menu.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			menu = (Menu) in.readObject();
			System.out.println("Data loaded successfully.");

			in.close();
			fileIn.close();

		} else {
			System.out.println("No existing save file.");
			menu = new Menu();
		}

		menu.runMenu();

		// to ensure serialize after user chooses exit application
		serialize();
		System.out.println("\nData saved successfully.");
		System.out.println("Thanks for using Bineco.");

	}

	/**
 	* Cette fonction permet de sauvegarder les changements faite par l'utilisateur a travers le menu.
	*/
	public static void serialize() throws IOException, FileNotFoundException, ClassNotFoundException {
		FileOutputStream fileOut = new FileOutputStream("Menu.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(menu);
		out.close();
		fileOut.close();
	}



}