import java.util.Scanner;

public class ContactsApplication {



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

	}


	public static void addNewContact() {


	}

	public static void searchByName() {


	}

	public static void deleteContact() {

	}





}
