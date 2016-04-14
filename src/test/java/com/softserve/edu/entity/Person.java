package com.softserve.edu.entity;

interface IFirstName {
	ILastName setFirstName(String firstName);
}

interface ILastName {
	IEmail setLastName(String lastName);
}

interface IEmail {
	IBuildPerson setEmail(String email);
}

interface IBuildPerson {
	Person build();
}

public class Person implements IFirstName, ILastName, IEmail, IBuildPerson, IPersonExt {
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phoneNumber;

	private Person() {
		this.middleName = new String();
		this.phoneNumber = new String();
	}

	// -----static factory -----
	public static IFirstName get() {
		return new Person();
	}

	// ----- setters -----
	public ILastName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public IEmail setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public IBuildPerson setEmail(String email) {
		this.email = email;
		return this;
	}

	public Person build() {
		return this;
	}

	public IPersonExt setMiddlename(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public IPersonExt setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	// ----- getters -----
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
