package com.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
    private AddressBook addressBook;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("Alice Johnson", "1234567890", "alice.johnson@example.com");
        addressBook.addContact(contact);

        Contact foundContact = addressBook.searchContact("Alice Johnson");
        assertNotNull(foundContact);
        assertEquals("Alice Johnson", foundContact.getName());
    }

    @Test
    void testViewAllContacts() {
        addressBook.addContact(new Contact("Alice", "1112223333", "alice@example.com"));
        addressBook.addContact(new Contact("Bob", "4445556666", "bob@example.com"));

        assertDoesNotThrow(addressBook::viewAllContacts);
    }

    @Test
    void testSearchContact() {
        Contact contact = new Contact("Charlie Brown", "9876543210", "charlie.brown@example.com");
        addressBook.addContact(contact);

        Contact found = addressBook.searchContact("Charlie Brown");
        assertNotNull(found);
        assertEquals("Charlie Brown", found.getName());

        Contact notFound = addressBook.searchContact("Nonexistent Contact");
        assertNull(notFound);
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("David Green", "5555555555", "david.green@example.com");
        addressBook.addContact(contact);

        assertTrue(addressBook.deleteContact("David Green"));
        assertNull(addressBook.searchContact("David Green"));

        // Attempt to delete a contact that doesn't exist
        assertFalse(addressBook.deleteContact("Nonexistent Contact"));
    }
}
