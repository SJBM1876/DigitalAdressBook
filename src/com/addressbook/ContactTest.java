package com.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("John Doe", "1234567890", "john.doe@example.com");
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", contact.getName());
    }

    @Test
    void testSetName() {
        contact.setName("Jane Doe");
        assertEquals("Jane Doe", contact.getName());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    @Test
    void testGetEmail() {
        assertEquals("john.doe@example.com", contact.getEmail());
    }

    @Test
    void testSetEmail() {
        contact.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", contact.getEmail());
    }

    @Test
    void testToString() {
        String expected = "Name: John Doe\nPhone: 1234567890\nEmail: john.doe@example.com";
        assertEquals(expected, contact.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Contact anotherContact = new Contact("John Doe", "1112223333", "john.different@example.com");
        assertEquals(contact, anotherContact);
        assertEquals(contact.hashCode(), anotherContact.hashCode());

        Contact differentContact = new Contact("Jane Smith", "4445556666", "jane.smith@example.com");
        assertNotEquals(contact, differentContact);
    }
}
