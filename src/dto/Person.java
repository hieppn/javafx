package dto;

import java.sql.Date;

public abstract class Person {

	protected int id;
	protected String username;
	protected String firstName;
	protected String lastName;
	protected String Email;
	protected String Position;
	protected String Gender;
	protected String password;
	protected Date birthday;
	protected String phoneNumber;
	protected String address;

	public Person(String firstName, String lastName, String Email, String username, String password, String Positin,
			String Gender, Date birthday, String phoneNumber, String address) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.Position = Positin;
		this.Gender = Gender;
		this.password = password;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Person() {

	}

	public Person(int id, String firstName, String lastName, String Email, String username, String password,
			String Positin, String Gender, Date birthday, String phoneNumber, String address) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.Position = Positin;
		this.Gender = Gender;
		this.password = password;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract String getLastName();

	public abstract void setLastName(String lastName);

	public abstract String getEmail();

	public abstract void setEmail(String Email);

	public abstract String getPositin();

	public abstract void setPosition(String Position);

	public abstract String getGender();

	public abstract void setGender(String Gender);

	public abstract String getUsername();

	public abstract void setUsername(String username);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract Date getBirthday();

	public abstract void setBirthday(Date birthday);

	public abstract String getPhoneNumber();

	public abstract void setPhoneNumber(String phoneNumber);

	public abstract String getAddress();

	public abstract void setAddress(String address);

	
}
