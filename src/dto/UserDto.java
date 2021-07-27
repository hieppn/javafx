package dto;

import java.sql.Date;


public class UserDto extends Person{

	

	public UserDto() {

	}
	

	public UserDto(String firstName, String lastName, String Email, String username, String password, String Positin,
			String Gender, Date birthday, String phoneNumber, String address) {
		
		super(firstName,lastName,Email,username,password,Positin,Gender,birthday,phoneNumber,address);
	}
	

	
	public UserDto(int id,String firstName, String lastName, String Email, String username, String password, String Positin,
			String Gender, Date birthday, String phoneNumber, String address) {
		
		super(id,firstName,lastName,Email,username,password,Positin,Gender,birthday,phoneNumber,address);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getPositin() {
		return Position;
	}

	public void setPosition(String Position) {
		this.Position = Position;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
