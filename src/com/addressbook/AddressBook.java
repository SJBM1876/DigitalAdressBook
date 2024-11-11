package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    // A list to store Contact objects.
    private List<Contact> contacts;

    // Constructor to initialize the contacts list.
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    // Method to add a new contact to the address book.
    public void addContact(Contact contact) {
        contacts.add(contact); // Add the contact to the list.
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts in the address book.
    public void viewAllContacts() {
        if (contacts.isEmpty()) { // Check if the contact list is empty.
            System.out.println("No contacts available.");
        } else {
            // Loop through each contact and print its details.
            for (Contact contact : contacts) {
                System.out.println(contact); // Uses the overridden toString() method of Contact class.
                System.out.println("-------------------------");
            }
        }
    }

    // Method to search for a contact by name.
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            // Check if the contact's name matches the search term (case-insensitive).
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact; // Return the matching contact.
            }
        }
        return null; // Return null if no matching contact is found.
    }

    // Method to delete a contact by name.
    public boolean deleteContact(String name) {
        Contact contactToDelete = searchContact(name); // Search for the contact.
        if (contactToDelete != null) {
            contacts.remove(contactToDelete); // Remove the contact from the list.
            return true; // Indicate successful deletion.
        }
        return false; // Return false if the contact was not found.
    }
}
