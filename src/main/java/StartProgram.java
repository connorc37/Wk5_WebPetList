import java.util.List;
import java.util.Scanner;

import controller.PetHelper;
import model.Pet;

/**
 * @author Corey Connor - cconnor3
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static PetHelper ph = new PetHelper();

	private static void addAPet() {
		System.out.print("Enter a type: ");
		String type = in.nextLine();
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter an owner: ");
		String owner = in.nextLine();
		
		Pet toAdd = new Pet(type, name, owner);
		ph.addPet(toAdd);
	}

	private static void deleteAPet() {
		System.out.print("Enter the type: ");
		String type = in.nextLine();
		System.out.print("Enter the name: ");
		String name = in.nextLine();
		System.out.print("Enter the owner: ");
		String owner = in.nextLine();
		
		Pet toDelete = new Pet(type, name, owner);
		ph.deletePet(toDelete);
	}

	private static void editAPet() {
		// Determine how the user would like to search.
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by type");
		System.out.println("2 : Search by name");
		System.out.println("3 : Search by owner");
		int searchBy = in.nextInt();
		in.nextLine();

		// Call the appropriate method.
		List<Pet> foundPets;
		if (searchBy == 1) {
			System.out.print("Enter the type: ");
			String type = in.nextLine();
			foundPets = ph.searchForPetByType(type);
		}
		else if (searchBy == 2) {
			System.out.print("Enter the name: ");
			String name = in.nextLine();
			foundPets = ph.searchForPetByName(name);
		}
		else {
			System.out.print("Enter the owner: ");
			String owner = in.nextLine();
			foundPets = ph.searchForPetByOwner(owner);
		}
		
		// Show matching results if they exist.
		if (foundPets.isEmpty()) {
			System.out.println("No matches found...");
		}
		else {
			System.out.println("Pet(s) found!");
			for (Pet p : foundPets) {
				System.out.println(p.getId() + " : " + p.returnPetDetails());
			}
			
			// Determine which match to edit.
			System.out.print("Enter ID to edit: ");
			int idToEdit = in.nextInt();

			// Determine what to edit.
			Pet toEdit = ph.searchForPetById(idToEdit);
			System.out.println("Editing " + toEdit.getOwner() + "'s " + toEdit.getType() + ", " + toEdit.getName());
			System.out.println("1 : Update type");
			System.out.println("2 : Update name");
			System.out.println("3 : Update owner");
			int update = in.nextInt();
			in.nextLine();

			// Get new info and call setter.
			if (update == 1) {
				System.out.print("New type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
				} 
			else if (update == 2) {
				System.out.print("New name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			}
			else {
				System.out.print("New owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			}
			
			// Update.
			ph.updatePet(toEdit);
		}
	}
	
	private static void viewAllPets() {
		List<Pet> allPets = ph.showAllPets();
		
		for(Pet p : allPets) {
			System.out.println(p.returnPetDetails());
		}
	}
	
	public static void menu() {
		boolean exit = false;
		
		System.out.println("Welcome to my animal database thing!");
		while (!exit) {
			System.out.println("What would you like to do?");
			System.out.println("1 : Add a pet");
			System.out.println("2 : Delete a pet");
			System.out.println("3 : Edit an existing pet's details");
			System.out.println("4 : View current pet list");
			System.out.println("5 : Exit");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPet();
			}
			else if (selection == 2) {
				deleteAPet();
			}
			else if (selection == 3) {
				editAPet();
			}
			else if (selection == 4) {
				viewAllPets();
			}
			else {
				ph.cleanUp();
				System.out.println("Have a great day!");
				exit = true;
			}
		}
	}

	public static void main(String[] args) {
		menu();
	}
}