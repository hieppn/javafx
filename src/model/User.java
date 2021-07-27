package model;

import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

	private SimpleIntegerProperty id;
	private SimpleStringProperty username;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty Email;
	private SimpleStringProperty Position;
	private SimpleStringProperty Gender;
	private SimpleStringProperty password;
	private SimpleStringProperty birthday;
	private SimpleStringProperty phoneNumber;
	private SimpleStringProperty address;

	public User(SimpleIntegerProperty id, SimpleStringProperty firstName, SimpleStringProperty lastName,
			SimpleStringProperty Email, SimpleStringProperty username, SimpleStringProperty password,
			SimpleStringProperty Position, SimpleStringProperty Gender, SimpleStringProperty birthday,
			SimpleStringProperty phoneNumber, SimpleStringProperty address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.username = username;
		this.password = password;
		this.Position = Position;
		this.Gender = Gender;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public User() {
		this.id = new SimpleIntegerProperty();
		this.username = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.lastName = new SimpleStringProperty();
		this.firstName = new SimpleStringProperty();
		this.Gender = new SimpleStringProperty();
		this.birthday = new SimpleStringProperty();
		this.Email = new SimpleStringProperty();
		this.address = new SimpleStringProperty();
		this.phoneNumber = new SimpleStringProperty();
		this.Position = new SimpleStringProperty();
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	//////////////////////////
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}

	////////////////////////
	public String getLastName() {
		return this.lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	////////////////////////
	public String getDateOfBirth() {
		return this.birthday.get();
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.birthday.set(dateOfBirth);
	}

	////////////////////////
	public String getPhoneNumber() {
		return this.phoneNumber.get();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	////////////////////////
	public String getGender() {
		return this.Gender.get();
	}

	public void setGender(String gender) {
		this.Gender.set(gender);
	}

	////////////////////////
	public String getPosition() {
		return this.Position.get();
	}

	public void setPosition(String Position) {
		this.Position.set(Position);
	}

	////////////////////////
	public String getUserName() {
		return this.username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	////////////////////////
	public String getPassword() {
		return this.password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	////////////////////////
	public String getEmail() {
		return this.Email.get();
	}

	public void setEmail(String Email) {
		this.Email.set(Email);
	}

	////////////////////////
	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}
	////////////////////////
}
