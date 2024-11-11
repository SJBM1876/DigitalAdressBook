package com.addressbook;

import java.util.Objects; // Import for utility functions

public class Contact {
    // Private fields to store the contact's data
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor to initialize the Contact object
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter and setter methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Overriding toString() method to display contact information neatly
    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phoneNumber + "\nEmail: " + email;
    }

    // Overriding equals() method to check equality based on contact name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name);
    }

    // Overriding hashCode() to generate unique hash code for contact objects
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



