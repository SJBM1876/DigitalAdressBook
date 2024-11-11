package com.addressbook;

import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {
        // Create an instance of AddressBook to manage contacts
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu options
            System.out.println("\n--- Digital Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Option to add a new contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    // Create a new Contact object and use the setter methods to set values
                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;

                case 2: // Option to view all contacts
                    System.out.println("\nAll Contacts:");
                    addressBook.viewAllContacts();
                    break;

                case 3: // Option to search for a contact by name
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact contact = addressBook.searchContact(searchName);
                    if (contact != null) {
                        System.out.println("\nContact Found:\n" + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4: // Option to delete a contact by name
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    if (addressBook.deleteContact(deleteName)) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5: // Option to exit the application
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;

                default: // Handle invalid menu options
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5); // Continue looping until the user chooses to exit

        scanner.close(); // Close the scanner to free resources
    }
}


