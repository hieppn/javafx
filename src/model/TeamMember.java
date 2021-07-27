package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TeamMember {

	    	private SimpleIntegerProperty id;
			private SimpleStringProperty lastName;
			private SimpleStringProperty firstName;
			private SimpleStringProperty dateOfBirth;
			private SimpleStringProperty email;
			private SimpleStringProperty address;
			private SimpleStringProperty phone;
			private SimpleStringProperty gender;
			private SimpleStringProperty position;
			
			
			public TeamMember() {
				this.id = new SimpleIntegerProperty();
				this.lastName = new SimpleStringProperty();
				this.firstName = new SimpleStringProperty();
				this.address = new SimpleStringProperty();
				this.phone = new SimpleStringProperty();
				this.dateOfBirth = new SimpleStringProperty();
				this.gender = new SimpleStringProperty();
				this.email = new SimpleStringProperty();
				this.position = new SimpleStringProperty();
				
			}
			

			public TeamMember(int id, String lastName, String firstName, String address, String phone, String dateOfBirth,
					String gender, String email, String position) {
				this.id = new SimpleIntegerProperty(id);
				this.lastName = new SimpleStringProperty(lastName);
				this.firstName = new SimpleStringProperty(firstName);
				this.address = new SimpleStringProperty(address);
				this.phone = new SimpleStringProperty(phone);
				this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
				this.gender = new SimpleStringProperty(gender);
				this.email = new SimpleStringProperty(email);
				this.position = new SimpleStringProperty(position);
			}

			public TeamMember(String lastName, String firstName, String address, String phone, String dateOfBirth,
					String gender, String email, String position) {
				this.id = new SimpleIntegerProperty();
				this.lastName = new SimpleStringProperty(lastName);
				this.firstName = new SimpleStringProperty(firstName);
				this.address = new SimpleStringProperty(address);
				this.phone = new SimpleStringProperty(phone);
				this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
				this.gender = new SimpleStringProperty(gender);
				this.email = new SimpleStringProperty(email);
				this.position = new SimpleStringProperty(position);
			}
			
			public int getId() {
				return id.get();
			}

			public void setId(int id) {
				this.id.set(id);
			}

			public String getLastName() {
				return lastName.get();
			}

			public void setLastName(String lName) {
				this.lastName.set(lName);
				;
			}

			public String getFirstName() {
				return firstName.get();
			}

			public void setFirstName(String fName) {
				this.firstName.set(fName);
				;
			}

			public String getDateOfBirth() {
				return dateOfBirth.get();
			}

			public void setDateOfBirth(String dateOfBirth) {
				this.dateOfBirth.set(dateOfBirth);
				;
			}

			public String getEmail() {
				return email.get();
			}

			public void setEmail(String email) {
				this.email.set(email);
			}

			public String getAddress() {
				return address.get();
			}

			public void setAddress(String address) {
				this.address.set(address);
			}

			public String getPhone() {
				return phone.get();
			}

			public void setPhone(String phone) {
				this.phone.set(phone);
				;
			}

			public String getGender() {
				return gender.get();
			}

			public void setGender(String gender) {
				this.gender.set(gender);
			}
			
			public String getPosition() {
				return position.get();
			}

			public void setPosition(String position) {
				this.position.set(position);
			}

		}

