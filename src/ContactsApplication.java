import java.util.Scanner;

public class ContactsApplication {

	static Scanner sc = new Scanner(System.in);
	static Input in = new Input(sc);

	public static void main(String[] args) {
		System.out.format(showMenu());
//		init();
//		int testInt = in.getInt();
//		System.out.println(testInt);
		in.getInt();

	}

	public static void init(String[] args) {

	}

	public static String showMenu() {
	return ("1. View contacts.\n" +
			"2. Add a new contact.\n" +
			"3. Search a contact by name.\n" +
			"4. Delete an existing contact.\n" +
			"5. Exit.\n" +
			"Enter an option (1, 2, 3, 4 or 5):");

	}
	public static void menuApplication() {
//		we will use if/else statements
	if (in.getInt() == 1) {
		viewContacts();
		menuApplication();
	} else if (in.getInt() == 2) {
		addNewContact();
		menuApplication();
	} else if (in.getInt() == 3) {
		searchByName();
		menuApplication();
	} else if (in.getInt() == 4) {
		deleteContact();
		menuApplication();
	} else if (in.getInt() == 5) {
		System.out.println("Goodbye");
	}

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
