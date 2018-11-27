import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {
	static String directory = "src/.";
	static String filename = "contacts.txt";

	static Path dataDirectory = Paths.get(directory);
	static Path dataFile = Paths.get(directory, filename);
	static Path p = Paths.get(directory, filename);


	public static void main(String[] args) {
		init();
	}

	public static void init() {
		menuApplication();
	}


	public static void menuApplication() {

		System.out.format(showMenu());

		Scanner sc = new Scanner(System.in);
		Input in = new Input(sc);
		int userInput = in.getInt();

//		we will use if/else statements
	if (userInput == 1) {
		viewContacts();
		menuApplication();
	} else if (userInput == 2) {
		addNewContact();
		menuApplication();
	} else if (userInput == 3) {
		searchByName();
		menuApplication();
	} else if (userInput == 4) {
		deleteContact();
		menuApplication();
	} else if (userInput == 5) {
		System.out.println("Goodbye");
	}

	}

	public static String showMenu() {
		return ("1. View contacts.\n" +
				"2. Add a new contact.\n" +
				"3. Search a contact by name.\n" +
				"4. Delete an existing contact.\n" +
				"5. Exit.\n" +
				"Enter an option (1, 2, 3, 4 or 5):\n");
	}

	public static void viewContacts() {
//		System.out.println(p);
		List<String> contacts = new ArrayList<>();
		try {
			contacts = Files.readAllLines(p);
			for (int i = 0; i < contacts.size(); i += 1) {
				System.out.println(contacts.get(i));
			}
			} catch(IOException e){
				e.printStackTrace();
				System.out.println(contacts);
			}
	}


	public static void addNewContact() {
		List<String> addContact = Arrays.asList("Joaquin | 1232101234", "Juan | 3242344567");
	try {
		Files.write(p, addContact, StandardOpenOption.APPEND);
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.out.println(addContact);
	}

	public static void searchByName() {


	}

	public static void deleteContact() {

	}





}
