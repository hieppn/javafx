package dao;

import dto.LeaderDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaderDaoImpl implements LeaderDao{

	@Override
	public LeaderDto getLeaderByPosition(String leaderPosition) {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE POSITION = '" + leaderPosition + "'");

			if (rs.next()) {
				LeaderDto leader = new LeaderDto();
				leader.setId(rs.getInt("ID"));
				leader.setLastName(rs.getString("LASTNAME"));
				leader.setLastName(rs.getString("LASTNAME"));
				

				return leader;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LeaderDto> getAllLeaders() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPerson.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE POSITION = 'Leader'");
			
			List<LeaderDto> leaders = new ArrayList<>();
			while (rs.next()) {
				LeaderDto leader = new LeaderDto();
				leader.setId(rs.getInt("ID"));
				leader.setLastName(rs.getString("LASTNAME"));
				leader.setFirstName(rs.getString("FIRSTNAME"));
				leader.setDateOfBirth(rs.getDate("BIRTHDAY"));
				leader.setEmail(rs.getString("EMAIL"));
				leader.setAddress(rs.getString("ADDRESS"));
				leader.setPhone(rs.getString("PHONE_NUMBER"));
				leader.setGender(rs.getString("GENDER"));
				leader.setPosition(rs.getString("POSITION"));
				
				
				leaders.add(leader);
			}

			return leaders;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void insertLeader(LeaderDto leader) {
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "INSERT INTO PROJECT1 VALUES(null, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			//ps.setInt(1, project.getProjectID());
			ps.setString(1, leader.getFirstName());
			ps.setString(2, leader.getLastName());
			ps.setString(3, leader.getEmail());
			ps.setString(4, leader.getGender());
			ps.setDate(5, leader.getDateOfBirth());
			ps.setString(6, leader.getPhone());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	@Override
	public void deleteLeader(Integer leaderID) {
			Connection connection = ConnectionPerson.getConnection();
			try {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("DELETE FROM USERS WHERE ID = '" + leaderID + "'");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
				
	}

	@Override
	public void updateLeader(LeaderDto leader) {
		Connection connection = ConnectionPerson.getConnection();
		try {
			String queryString = "UPDATE USERS SET FIRSTNAME =?,LASTNAME=?,BIRTHDAY = ?, EMAIL=?, PHONE_NUMBER = ?, ADDRESS = ? WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, leader.getFirstName());
			ps.setString(2, leader.getLastName());
			ps.setDate(3, leader.getDateOfBirth());
			ps.setString(4,leader.getEmail());
			ps.setString(5, leader.getPhone());
			ps.setString(6,leader.getAddress());
			ps.setInt(7, leader.getId());
			 
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public LeaderDto getLeaderById(Integer leaderID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}