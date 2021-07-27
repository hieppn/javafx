package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.UserDto;

public class UserDaoImpl implements UserDao {
	static List<UserDto> list1 = new ArrayList<>();

	@Override
	public UserDto getPersonBySignUp(String username, String pass) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM USERS WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + pass + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getPersonByLeader(String username,String Password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD='"+Password+"' AND POSITION = 'Leader'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getAdmin(String username, String Password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" 
			+ username + "' AND PASSWORD='"+Password+"' AND POSITION = 'Manager'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getPersonByMember(String username, String Password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" 
			+ username + "' AND PASSWORD='"+Password+"' AND POSITION = 'Team member'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public UserDto getUserById(Integer id) {

		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE ID = '" + id + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS ");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				list1.add(userDto);
			}
			return list1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public void insertUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "INSERT INTO USERS VALUE(NULL,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(queryString);

			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getPositin());
			ps.setString(7, user.getGender());
			ps.setDate(8, user.getBirthday());
			ps.setString(9, user.getPhoneNumber());
			ps.setString(10, user.getAddress());

			ps.executeUpdate();
			list1.add(user);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	@Override
	public void deleteUser(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM USERS WHERE USERNAME = '" + username + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionPerson.getConnection();
			String queryString = "UPDATE USERS SET BIRTHDAY = ?, PHONE_NUMBER = ?, ADDRESS = ?, PASSWORD=? WHERE ID = ?";
			ps = connection.prepareStatement(queryString);
			ps.setDate(1, user.getBirthday());
			ps.setString(2, user.getPhoneNumber());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getId());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public UserDto getUserByUserAndPass(String username, String password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM USERS WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + password + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setFirstName(rs.getString("FIRSTNAME"));
				userDto.setLastName(rs.getString("LASTNAME"));
				userDto.setEmail(rs.getString("EMAIL"));
				userDto.setPosition(rs.getString("POSITION"));
				userDto.setGender(rs.getString("GENDER"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDto> search(UserDto person) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionPerson.getConnection();
			stmt = connection.createStatement();

			StringBuffer query = new StringBuffer("SELECT * FROM USERS");
			query.append(" WHERE 1 > 0 ");
			if (person.getUsername() != null) {
				query.append(" AND USERNAME LIKE '%" + person.getUsername() + "%'");
			}
			if (person.getPhoneNumber() != null) {
				query.append(" AND PHONE_NUMBER = '" + person.getPhoneNumber() + "'");
			}
			ResultSet rs = stmt.executeQuery(query.toString());

			List<UserDto> list = new ArrayList<>();
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));

				list.add(userDto);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
