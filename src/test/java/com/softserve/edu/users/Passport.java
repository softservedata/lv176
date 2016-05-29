package com.softserve.edu.users;

public class Passport implements IPassport {

	private String passportSeria;
	private String passportNumber;
	private String publishedByData;

	public Passport() {
		this.passportSeria = new String();
		this.passportNumber = new String();
		this.publishedByData = new String();
	}

	public Passport(String passportSeria, String passportNumber, String publishedByData) {
		this.passportSeria = passportSeria;
		this.passportNumber = passportNumber;
		this.publishedByData = publishedByData;
	}

	// -----static factory -----

	public static Passport get() {
		return new Passport();
	}

	// ----- setters -----

	public Passport setPassportSeria(String passportSeria) {
		this.passportSeria = passportSeria;
		return this;
	}

	public Passport setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
		return this;
	}

	public Passport setPublishedByData(String publishedByData) {
		this.publishedByData = publishedByData;
		return this;
	}

	// ----- setters -----

	public String getPassportSeria() {
		return passportSeria;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getPublishedByData() {
		return publishedByData;
	}

}
