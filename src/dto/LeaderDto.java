package dto;
import java.sql.Date;

public class LeaderDto {
	
	private int id;
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private String email;
	private String address;
	private String phone;
	private String gender;
	private String position;
	
	public LeaderDto() {
		
	}
	
	public LeaderDto(int id, String lastName, String firstName, Date dateOfBirth, String  email, 
			String address, String phone, String gender, String position) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.position = position;
		
	}
	
	public LeaderDto( String lastName, String firstName, Date dateOfBirth, String  email, 
			String address, String phone, String gender, String position ) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.position = position;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}

