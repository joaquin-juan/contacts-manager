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

	static Path p = Paths.get(directory, filename);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	public static void init() {
		viewContacts();
		menuApplication();
	}


	public static void menuApplication() {

		System.out.format(showMenu());


		Input in = new Input(sc);
		int userInput = in.getInt();

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
		return ("\n1. View contacts.\n" +
				"2. Add a new contact.\n" +
				"3. Search a contact by name.\n" +
				"4. Delete an existing contact.\n" +
				"5. Exit.\n\n" +
				"Enter an option (1, 2, 3, 4 or 5):\n\n");
	}
	public static String showHeadings() {
		return ("\nName | Phone number\n" +
				"---------------");
	}

	public static void viewContacts() {
		List<String> contacts = new ArrayList<>();
		try {
			contacts = Files.readAllLines(p);
			System.out.println(showHeadings());
			for (int i = 0; i < contacts.size(); i += 1) {
				System.out.println(contacts.get(i));
			}
			} catch(IOException e){
				e.printStackTrace();
			}
	}


	public static void addNewContact() {
		System.out.println("Please enter the first name of the contact you wish to add.");
		Input in = new Input(sc);
		String firstName = in.getString();
		System.out.println("Please enter the last name of the contact you wish to add.");
		String lastName = in.getString();
		System.out.println("Please enter the phone number of the contact you wish to add.");
		String phoneNumber = in.getString();

		List<String> addContact = Arrays.asList(firstName + " " + lastName + " " + phoneNumber);
	try {
		Files.write(p, addContact, StandardOpenOption.APPEND);
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.out.println(addContact);
	}

	public static void searchByName() {
		System.out.println("Please enter the first name of the contact you wish to search for.");
		Input in = new Input(sc);
		String userInput = in.getString();
		String searchedContact = "";
		List<String> contacts = new ArrayList<>();
		try {
			contacts = Files.readAllLines(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String contact : contacts) {
			if (contact.toLowerCase().startsWith(userInput.toLowerCase())) {
				searchedContact = contact;
				System.out.println("We found your contact!");
				System.out.println(searchedContact);
			}
		}
	}

	public static void deleteContact() {
		System.out.println("Please enter the first name of the contact you wish to delete.");
		Input in = new Input(sc);
		String userInput = in.getString();
		String deletedContact = "";
		List<String> contacts = new ArrayList<>();
		try {
			contacts = Files.readAllLines(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String contact : contacts) {
			if (contact.toLowerCase().startsWith(userInput.toLowerCase())) {
				deletedContact = contact;
			}
		}
		contacts.remove(deletedContact);
		try {
			Files.write(p, contacts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


//Extra bonus: refactor to prompt user to save changes right away or save changes to the contacts.txt at a later time. This will require changes to allow a global variable to be changed with each manipulation by the user.


}
