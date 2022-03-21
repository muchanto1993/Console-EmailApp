package com.mab;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String departement;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

//		System.out.println("EMAIL CREATED : " + this.firstName + " " + this.lastName);

		// Call a method asking for the departement - return the departement
		this.departement = setDepartement();
//		System.out.println("Departement: " + this.departement);

		// Call a method that returns a random password
		this.password = randomPasssword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);

		// Combine elements to generate email
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departement + "." + companySuffix;
//		System.out.println("Your email is: " + this.email);
	}

	// Ask for the departement
	private String setDepartement() {
		System.out.print(
				"DEPARTEMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter departement code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		switch (depChoice) {
		case 1:
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		default:
			return "";
		}

	}

	// Generate a random password
	private String randomPasssword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}

		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	// set the alternate email
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public void showInfo() {
		System.out.print("DISPLAY NAME : " + firstName + " " + lastName + "\nCOMPANY EMAIL : " + email
				+ "\nMAILBOX CAPACITY : " + mailboxCapacity + "mb");
	}

}
